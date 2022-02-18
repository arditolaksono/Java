/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ardito
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        String Username;
        String Password;

        Password = "123456";
        Username = "admin";
        ServerSocket ss;
        Socket s;
        DataInputStream input;

        try {
            ss = new ServerSocket(212);
            System.out.println("Server udah siap");
            s = ss.accept();
            System.out.println("Ada client yang hadir");

            //untuk baca data dari client
            input = new DataInputStream(s.getInputStream());
            

            // kirim data ke client
            PrintStream output = new PrintStream(s.getOutputStream());
            
            
                String str,str1;
                //membaca data dari client
                str = input.readLine();
                System.out.println("Client memasukan username");
                str1 = input.readLine();
                System.out.println("Client memasukan password");
                
                // mengecek username dan password
            if(str.equals(Username) && str1.equals(Password)){
            output.println("LOGIN BERHASIL!");
            
            }else{
                output.println("Username atau password salah");
            } 
            
            output.close();
            input.close();
            s.close();
            ss.close();
            
            
            } catch (IOException e) {}
        

    }
}
