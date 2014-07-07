package org.lei.util;

import java.util.ArrayList;
import java.util.List;

public class CountSerialLength {
		public List<Integer>countSerialLength(List<String> list){
			int count0_100 = 0;
			int count100_200 = 0;
			int count200_300 = 0;
			int count300_400 = 0;
			int count400_500 = 0;
			int count500_600 = 0;
			int count600_700 = 0;
			int count700_800 = 0;
			int count800_900 = 0;
			int count900_1000 = 0;
			int count1000_1500 = 0;
			int count1500_2000 = 0;
			int count2000_2500 = 0;
			int count2500_3000 = 0;
			int count3000_50000 = 0;
			
			for(String str :list){
				if(str.length()>0&&str.length()<=100)
					count0_100++;
				else if(str.length()>100&&str.length()<=200)
					count100_200++;
				else if(str.length()>200&&str.length()<=300)
					count200_300++;
				else if(str.length()>300&&str.length()<=400)
					count300_400++;
				else if(str.length()>400&&str.length()<=500)
					count400_500++;
				else if(str.length()>500&&str.length()<=600)
					count500_600++;
				else if(str.length()>600&&str.length()<=700)
					count600_700++;
				else if(str.length()>700&&str.length()<=800)
					count700_800++;
				else if(str.length()>800&&str.length()<=900)
					count800_900++;
				else if(str.length()>900&&str.length()<=1000)
					count900_1000++;
				else if(str.length()>1000&&str.length()<=1500)
					count1000_1500++;
				else if(str.length()>1500&&str.length()<=2000)
					count1500_2000++;
				else if(str.length()>2000&&str.length()<=2500)
					count2000_2500++;
				else if(str.length()>2500&&str.length()<=3000)
					count2500_3000++;
				else 
					count3000_50000++;
			}
			
			List<Integer>serialLengthCounts = new ArrayList<Integer>();
			serialLengthCounts.add(count0_100);
			serialLengthCounts.add(count100_200);
			serialLengthCounts.add(count200_300);
			serialLengthCounts.add(count300_400);
			serialLengthCounts.add(count400_500);
			serialLengthCounts.add(count500_600);
			serialLengthCounts.add(count600_700);
			serialLengthCounts.add(count700_800);
			serialLengthCounts.add(count800_900);
			serialLengthCounts.add(count900_1000);
			serialLengthCounts.add(count1000_1500);
			serialLengthCounts.add(count1500_2000);
			serialLengthCounts.add(count2000_2500);
			serialLengthCounts.add(count2500_3000);
			serialLengthCounts.add(count3000_50000);
			
			return serialLengthCounts;
			
		}
}
