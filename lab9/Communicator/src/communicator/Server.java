package communicator;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.awt.Color;

public class Server {

  private int port;
  private List<User> clients;
  private ServerSocket server;

  public static void main(String[] args) throws IOException {
    new Server(6666).run();
  }

  public Server(int port) {
    this.port = port;
    this.clients = new ArrayList<User>();
  }

  public void run() throws IOException {
    server = new ServerSocket(port) {
      protected void finalize() throws IOException {
        this.close();
      }
    };
    System.out.println("Port 6666 is now open.");

    while (true) {
      Socket client = server.accept();

      String nickname = (new Scanner ( client.getInputStream() )).nextLine();
      nickname = nickname.replace(",", "");
      nickname = nickname.replace(" ", "_");
      System.out.println("New Client: \"" + nickname + "\"\n\t Host:" + client.getInetAddress().getHostAddress());
      User newUser = new User(client, nickname);
      this.clients.add(newUser);
      newUser.getOutStream().println("<b>Witaj</b> " + newUser.toString());
      new Thread(new UserHandler(this, newUser)).start();
    }
  }

  public void removeUser(User user){
    this.clients.remove(user);
  }

  public void broadcastMessages(String msg, User userSender) {
    for (User client : this.clients) {
      client.getOutStream().println(
          userSender.toString() + ": " + msg);
    }
  }

  public void broadcastAllUsers(){
    for (User client : this.clients) {
      client.getOutStream().println(this.clients);
    }
  }

  public void sendMessageToUser(String msg, User userSender, String user){
    boolean find = false;
    for (User client : this.clients) {
      if (client.getNickname().equals(user) && client != userSender) {
        find = true;
        userSender.getOutStream().println(userSender.toString() + " -> " + client.toString() +": " + msg);
        client.getOutStream().println(
            "(<b>Private</b>)" + userSender.toString() + ": " + msg);
      }
    }
    if (!find) {
      userSender.getOutStream().println(userSender.toString() + " -> (<b>no one!</b>): " + msg);
    }
  }
}

class UserHandler implements Runnable {

  private Server server;
  private User user;

  public UserHandler(Server server, User user) {
    this.server = server;
    this.user = user;
    this.server.broadcastAllUsers();
  }

  public void run() {
    String message;
    Scanner sc = new Scanner(this.user.getInputStream());
    while (sc.hasNextLine()) {
      message = sc.nextLine();

      if (message.charAt(0) == '@'){
        if(message.contains(" ")){
          System.out.println("private msg : " + message);
          int firstSpace = message.indexOf(" ");
          String userPrivate= message.substring(1, firstSpace);
          server.sendMessageToUser(message.substring(firstSpace+1, 
            message.length()), user, userPrivate);
        }
      } 
      else {
        server.broadcastMessages(message, user);
      }
    }
    server.removeUser(user);
    this.server.broadcastAllUsers();
    sc.close();
  }
}

class User {
  private static int nbUser = 0;
  private int userId;
  private PrintStream streamOut;
  private InputStream streamIn;
  private String nickname;
  private Socket client;

  public User(Socket client, String name) throws IOException {
    this.streamOut = new PrintStream(client.getOutputStream());
    this.streamIn = client.getInputStream();
    this.client = client;
    this.nickname = name;
    this.userId = nbUser;
    nbUser += 1;
  }

  public PrintStream getOutStream(){
    return this.streamOut;
  }

  public InputStream getInputStream(){
    return this.streamIn;
  }

  public String getNickname(){
    return this.nickname;
  }

  public String toString(){

    return this.getNickname();
  }
}