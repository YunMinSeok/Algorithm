import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
  public String solution(String m, String[] musicinfos) throws Exception {

		String answer = "(None)";

		m = m.replaceAll("C#","c");
		m = m.replaceAll("D#","d");
		m = m.replaceAll("F#","f");
		m = m.replaceAll("G#","g");
		m = m.replaceAll("A#","a");
		
		int max = -1 ;
		
		for ( int i = 0;  i < musicinfos.length; i++ ) {

			String[] music = musicinfos[i].split(",");

			SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);

			Date start = f.parse(music[0]);
			Date end = f.parse(music[1]);
			long diff = end.getTime() - start.getTime() ;
			long minute = diff / (1000*60);

			String musicInfo = music[3];

			musicInfo = musicInfo.replaceAll("C#","c");
			musicInfo = musicInfo.replaceAll("D#","d");
			musicInfo = musicInfo.replaceAll("F#","f");
			musicInfo = musicInfo.replaceAll("G#","g");
			musicInfo = musicInfo.replaceAll("A#","a");

			StringBuilder sb = new StringBuilder();
			boolean contains = false;

			int size = musicInfo.length();

			for ( int j = 0; j < minute; j++ ) {

				if ( sb.toString().length() >= m.length()*2 && j >= musicInfo.length()*2 ) break;

				sb.append(musicInfo.charAt(j%size));
				if ( sb.toString().length() >= m.length() && sb.toString().contains(m) ){
					contains=true;
					break;
				}
			}
			
			if ( contains ) {
                
				if ( max == (int)minute ) continue;
				
				if ( (int)minute > max ) {
					max = (int)minute;
					answer = music[2];
				}
			}
		}
		return answer;	
  }
}
