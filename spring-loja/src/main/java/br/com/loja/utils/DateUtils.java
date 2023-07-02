package br.com.loja.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	
		// converte uma data do tipo String numa data do tipo Date
		public static Date toDate(String date) {
			
			// caso seja vazio
			if(date == null) {
				return null;
			}
			// receber uma data no padrão YYYY-MM-DD
			int ano = Integer.parseInt(date.substring(0, 4));
			int mes = Integer.parseInt(date.substring(5, 7));
			int dia = Integer.parseInt(date.substring(8, 10)); 

			//Calendar cal = new GregorianCalendar(ano, mes - 1, dia);
			Calendar cal = new GregorianCalendar(ano, mes -1,dia);
			return cal.getTime();
		}

		/**
		 * Converte uma String em Date
		 * @param date Data em String para ser formatada
		 * @param format Formato da data, por padrão 'yyyy-MM-dd'
		 * @return um Date com o padrão especificado
		 */
		public static Date toDate(String date, String format) {
			if(format == null) {
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			Date response;
			try {
				response = simpleDateFormat.parse(date);
				return response;
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("A data não pôde ser convertida.");
			}
		}

		// converte uma data do tipo Date numa String
		public static String toString(Date data) {
			
			// caso seja vazio
			if (data == null) {
				return null;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(data);
		}

		// converte uma data do tipo Date numa String padrão BR
		public static String toStringPtBR(Date data) {

			// caso seja vazio
			if (data == null) {
				return null;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(data);
		}

}
