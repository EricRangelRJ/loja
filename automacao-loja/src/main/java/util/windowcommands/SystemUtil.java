package util.windowcommands;

import java.io.IOException;

public class SystemUtil {

	public static void fecharFirefox()  {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe /T");
		} catch (IOException e) {
			System.out.println("Erro ao fechar o navegador: " + e.getMessage());
		}
	}
	
	private SystemUtil() {
	}

}
