/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ardito
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket s = null;
        PrintStream output;
        BufferedReader pesan;
        DataInputStream input ;
        boolean isLanjutkan = true;

        try {
            s = new Socket("127.0.0.1", 212); //ip tujuan dan port

            // untuk kirim data ke server
            output = new PrintStream(s.getOutputStream());
            pesan = new BufferedReader(new InputStreamReader(System.in));

           
                System.out.println("MENU LOGIN");
                System.out.println("Masukan Username: ");
                output.println(pesan.readLine());
                System.out.println("Masukan password");
                output.println(pesan.readLine());

                //membaca data dari server
                input = new DataInputStream(s.getInputStream());

                String msg = input.readLine();
                System.out.println("Server : " + msg);

            output.close();
            input.close();
            s.close();
            
            

        } catch (IOException e) {
        }
    }

}
