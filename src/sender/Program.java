/*
HW# 9: In many situations, you need to transmit a sequence of packets across the network. You generally cannot do much about big connection problems (lots of packets getting lost). But for situations when only a few (perhaps 1) packets are lost, perhaps there's a way to use error correction codes to `correct' the lost packet. Use the Hamming(7,4) code to implement such a scheme... In any language, write 2 programs, "sender" and "reciever". The sender will get a block of data (input file), cut it into `packets' (smaller files). The reciever program will take those smaller files and reconstruct the original block of data (even when 1 packet is missing).

TIP: every 4bits of the input go into their own output file (creating 4 files---one per bit). Add 3 more files to be the Hamming parity, for a total of 7 output files. If any one of those files is lost, (and end up with 6 files), you can still reconstruct the 7 original files (and recover the original data from 4 of those files). If you want to, make the scheme general, where the user specifies number of output files to create---(perhaps they want to cut it into 256 files instead of 7, etc.).

Submit the source code to the sender and reciever programs. 
*/
package sender;

import java.io.File;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename;
		if (args.length<1){
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter file path: ");
			filename = scanner.next();
			scanner.close();
		}
		else filename = args[0];
		File f = new File(filename);
		Sender.splitFile(f,7,f.getName()); // 7 parts
		Sender.splitFile(f, 4, "checkCorrupt"); // 4 parts
	}
}
