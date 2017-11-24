import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContarFichero {

	public static void main(String[] args) {
		//Por parametro pon la ruta a algun fichero
		if(args.length != 1)
			System.err.println("Error de parametro");
		else {
			try {
				contar(args[0]);
			} catch (IOException  e) {
				System.err.println("Error de E/S: "+e.getMessage());

			}
			catch (InterruptedException e) {
				System.err.println("Error: "+e.getMessage());
			}
		}
	}
	public static void contar(String ruta) throws IOException, InterruptedException {
		ProcessBuilder pb1 = new ProcessBuilder("cat",ruta);
		ProcessBuilder pb2 = new ProcessBuilder("wc");
		
		Process p1 = pb1.start();
		Process p2 = pb2.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
		String linea = "";
		
		while ((linea = br.readLine())!=null) {
			bw.write(linea);
			bw.newLine();
		}
		
		linea = "";
		br.close();
		bw.close();
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

		while ((linea = br2.readLine())!=null) {
			System.out.println(linea);
		}
		
		br2.close();
		
		int s2 = p2.waitFor();
		
		System.out.println("Salida del proceso:"+ s2);
	}

}
