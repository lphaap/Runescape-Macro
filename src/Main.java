import java.awt.Robot;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.IntellitypeListener;
import com.melloware.jintellitype.JIntellitype;
//implements NativeKeyListener
public class Main {
	
										//Ohjelman aloitus
//------------------------------------------------------------------------------------------------------//	
	public static void main(String[] args) throws AWTException {
		
		String[][] items = { 
				{"x", "x", "x", "x"},
				{"F", "F", "F", "x"},
				{"F", "F2", "F", "P2"},
				{"F", "F2", "F", "P1"},
				{"F", "F", "F", "x"},
				{"x", "x", "x", "x"},
				{"T", "x", "x", "x"}
			};
		
		String[][] prayer = {
				{"0", "0", "0", "0", "0"},
				{"0", "0", "0", "0", "0"},	
				{"0", "0", "0", "0", "0"},	
				{"0", "0", "2", "0", "0"},	
				{"1", "0", "0", "1", "0"},	
				{"0", "0", "0", "0"}	
		};
		
		String[][] defSB = {
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","x","x","x","x","x","x"},
				{"x","2","x","x","x","x","x"},
				{"1","x","x","x","x","x","3"},
		};
		
		String[][] ancientSB = {
				{"x","x","x","x"},
				{"x","x","x","x"},
				{"x","x","x","x"},
				{"x","x","x","x"},
				{"3","2","x","x"},
				{"x","x","x","x"},
				{"1","x"}
		};
		
		String[][] lunarSB = {
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"x","x","x","x","x"},
				{"1","x","x","x","x"},
				{"x","x","1","x","x"},
		};
		
		//�l� koske!
		int[][] prayerKirja = {
				{1, 2, 3, 4, 4},
				{1, 2, 3, 5, 6},	
				{7, 4, 4, 1, 2},	
				{3, 8, 8, 8, 4},	
				{4, 8, 8, 8, 9},	
				{4, 4, 4, 4},	
		};
		
		//�l� koske!
		String[][] prayerTila = {
				{"", "", "", "", ""},
				{"", "", "", "", ""},	
				{"", "", "", "", ""},	
				{"", "", "", "", ""},	
				{"", "", "", "", ""},	
				{"", "", "", ""},	
		};
		
		int[][][] back = new int[7][4][2];
		int[][][] pray = new int[6][5][2];
		int[][][] ancient = new int[7][4][2];
		int[][][] defaultSB = new int[10][7][2];
		int[][][] lunar = new int[9][5][2];
		
		boolean backSijainti[] = new boolean[4];
		ArrayList<Integer> prTila = new ArrayList<Integer>(15);
		
		Scanner lukija = new Scanner(System.in);
		Robot robot = new Robot();

		int[] kalibrointi1 = new int[2];
		int[] kalibrointi2 = new int[2];
		int[] kalibrointi3 = new int[2];
		int[] kalibrointi4 = new int[2];
		int[] spec = new int[2];
		
		System.out.println("Tervetuloa!");
		System.out.println("");
		System.out.println("Anna kalibrointi pisteet!");
		System.out.println("");
		
		kalibrointi1 = kysy(lukija, 1);
		koordTulostus(kalibrointi1);
		
		kalibrointi2 = kysy(lukija, 2);
		koordTulostus(kalibrointi2);
		
		kalibrointi3 = kysy(lukija, 3);
		koordTulostus(kalibrointi3);
		
		kalibrointi4 = kysy(lukija, 4);
		koordTulostus(kalibrointi4);
				
		kalibroiItemit(back, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		kalibroiSpec(spec, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		kalibroiPrayer(pray, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		kalibroiAncient(ancient, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		kalibroiDefaultSB(defaultSB, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		kalibroiLunar(lunar, kalibrointi1, kalibrointi2, kalibrointi3, kalibrointi4);
		
		int SB = valitseSB(lukija);
		
		System.out.println("");
		System.out.println("Käynnistys: Paina Enter.. ");
		System.out.println("");
		System.out.println("Lopetus: Paina Esc.. ");
		lukija.nextLine();
	
		JIntellitype.getInstance().registerHotKey(1, 0 , (int)'Q'); //Heal 1
		JIntellitype.getInstance().registerHotKey(2, 0 , (int)'W'); //Gear Switch 1
		JIntellitype.getInstance().registerHotKey(3, 0 , (int)'E'); //Spell 1
		JIntellitype.getInstance().registerHotKey(4, 0 , (int)'R'); //Spec 1
		JIntellitype.getInstance().registerHotKey(11, 0 , (int)'S'); //Spec + Switch
		JIntellitype.getInstance().registerHotKey(12, 0 , (int)'D'); //Spell 2
		JIntellitype.getInstance().registerHotKey(14, 0 , (int)'A'); //Heal 2
		JIntellitype.getInstance().registerHotKey(5, 0 , (int)'1'); //Prayer switch 2
		JIntellitype.getInstance().registerHotKey(6, 0 , (int)'2'); //Prayer switch 1
		JIntellitype.getInstance().registerHotKey(7, 0 , (int)'3'); //Potion 1
		JIntellitype.getInstance().registerHotKey(8, 0 , (int)'4'); //Potion 2
		JIntellitype.getInstance().registerHotKey(9, 0 , (int)'5');
		JIntellitype.getInstance().registerHotKey(10, 0 , 27); //ESC - Lopetus
		JIntellitype.getInstance().registerHotKey(13, JIntellitype.MOD_CONTROL , (int)'B'); //Reset, Bank
		JIntellitype.getInstance().registerHotKey(15, 0 , 32); //Space - Panic tele
		JIntellitype.getInstance().registerHotKey(16, JIntellitype.MOD_SHIFT, (int)'E'); //SHIFT - Spell 3
		JIntellitype.getInstance().registerHotKey(17, JIntellitype.MOD_SHIFT, (int)'D'); //SHIFT - Spell 4
		JIntellitype.getInstance().registerHotKey(18, JIntellitype.MOD_SHIFT, (int)'W'); //SHIFT - Gear Switch 2
		JIntellitype.getInstance().registerHotKey(19, JIntellitype.MOD_SHIFT, (int)'S'); //SHIFT - Double Weapon Spec
		/*
		liikutusClick(robot, back[0][0][0]-40,back[0][0][1],0);
		napaytys(robot, 112); //F1
		robot.mouseMove(spec[0],spec[1]);
		robot.delay(500);
		napaytys(robot, 115); //F4
		for(int i = 0; i < 7; ++i) {
			for(int j = 0; j < 4; ++j) {
				robot.delay(60);
				robot.mouseMove(back[i][j][0],back[i][j][1] );
			}}
		napaytys(robot, 116); //F5
		for(int i = 0; i < 6; ++i) {
			for(int j = 0; j < 5; ++j) {
				robot.delay(60);
				robot.mouseMove(pray[i][j][0],pray[i][j][1] );
			}}
		
		napaytys(robot, 117); //F6
		
		 
		if(SB == 2) {
		for(int i = 0; i < 7; ++i) {
			for(int j = 0; j < 4; ++j) {
				robot.delay(60);
				robot.mouseMove(ancient[i][j][0],ancient[i][j][1] );
			}}
		}
		else if(SB == 1) {
	
		for(int i = 0; i < 10; ++i) {
			for(int j = 0; j < 7; ++j) {
				robot.delay(60);
				robot.mouseMove(defaultSB[i][j][0],defaultSB[i][j][1] );
			}}
		}
		else if(SB == 3) {
		
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 5; ++j) {
				robot.delay(60);
				robot.mouseMove(lunar[i][j][0],lunar[i][j][1] );
			}}
		}
		
		
		*/
		napaytys(robot, 115); //F4
		backSijainti[1] = true; 
		
		System.out.println("Ohjelma aloitus OK!");
		
		int[] potion1 = {4};
		int[] potion2 = {4};
		boolean[] sp = new boolean[1];
		
		
									//Hotkey-toiminnot
//------------------------------------------------------------------------------------------------------//	
	

	JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {	
		public void onHotKey(int aIdentifier) {
			switch(aIdentifier) {
			
			//Heal 1
			case 1 : { 
				sijaVaihto(1, backSijainti, robot);
				robot.delay(40);
				int[] s1 = hiiriSijainti();
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("F")){
							
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							items[i][j] = "F0";
							
							robot.mouseMove(s1[0], s1[1]);
							robot.delay(1660);
							break loop1;
						}
					}
				}
				break;
			}
				
			//Gear switch
			case 2: { 
				sijaVaihto(1, backSijainti, robot);
				robot.delay(40);
				int[] s2 = hiiriSijainti();
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("S1")){
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							robot.delay(20);
							
						}
					}
				}
				liikutusClick(robot,s2[0], s2[1],40);
				break;
			}
			
			//Spell 1
			case 3: {
				int s3[] = hiiriSijainti();
				sijaVaihto(3, backSijainti, robot);
				
				/*
				 * Ancient
				 */
				if(SB == 2) {
				for(int i = 0; i < 7; ++i) {
					for(int j = 0; j < ancientSB[i].length; ++j) {
						if(ancientSB[i][j] == "1") {
						robot.delay(30);
						liikutusClick(robot,ancient[i][j][0],ancient[i][j][1],0);
					}}
				}}
				else if(SB == 1) {
				/*
				 *Default SB 
				 */
				for(int i = 0; i < 10; ++i) {
					for(int j = 0; j < 7; ++j) {
						if(defSB[i][j] == "1") {
						robot.delay(20);
						liikutusClick(robot,defaultSB[i][j][0],defaultSB[i][j][1],0);
					}}
				}}
				else if(SB == 3) {
				/*
				 * Lunar
				 */
				for(int i = 0; i < 9; ++i) {
					for(int j = 0; j < 5; ++j) {
						if(lunarSB[i][j] == "1") {
						robot.delay(20);
						liikutusClick(robot,lunar[i][j][0],lunar[i][j][1],0);
					}}
				}}
				robot.delay(10);
				liikutusClick(robot, s3[0], s3[1], 35);
				
				break;
			}
			
			 //Spec 
			case 4: {
				int[] s4 = hiiriSijainti();
				if(backSijainti[0] != true) {
				sijaVaihto(0, backSijainti, robot);
				robot.delay(40);
				}
				liikutusClick(robot, spec[0], spec[1], 0);
				robot.delay(0);
				liikutusClick(robot,s4[0], s4[1],40);
				break;
			}
			
			//Prayer switch 2
			case 5: {
				int[] s5 = hiiriSijainti();
				
				sijaVaihto(2,backSijainti, robot);
				for(int a = 0; a < prayerTila.length; ++a) {
					for(int b = 0; b < prayerTila[a].length; ++b) {
						if(prayerTila[a][b] == "X") {
							prayerTila[a][b] = "x";
						}
					}
				}
				robot.delay(30);
				for(int i = 0; i < prayer.length; ++i ) {
					for(int j = 0; j < prayer[i].length; j++) {
						if(prayer[i][j].equals("1") || prayer[i][j].equals("12")) {
							liikutusClick(robot, pray[i][j][0], pray[i][j][1], 40);
							prayerTila[i][j] = "X";
							prTila.add(prayerKirja[i][j]);
							if(prayerKirja[i][j] == 4) {
								prTila.add(2);
								prTila.add(3);
							}
							if(prayerKirja[i][j] == 2 || prayerKirja[i][j] == 3) {
								prTila.add(4);
							}
							
						}
					}
				}
				pTilaPaivitys(prayerKirja, prayerTila, prayer, pray, prTila, robot);
				
				robot.delay(50);
				robot.mouseMove(s5[0], s5[1]);
				
				break;
			}
			
			//Prayer switch 1
			case 6: {
				int[] s6 = hiiriSijainti();
				sijaVaihto(2,backSijainti, robot);
				for(int a = 0; a < prayerTila.length; ++a) {
					for(int b = 0; b < prayerTila[a].length; ++b) {
						if(prayerTila[a][b] == "X") {
							prayerTila[a][b] = "x";
						}
					}
				}
				robot.delay(30);
				for(int i = 0; i < prayer.length; ++i ) {
					for(int j = 0; j < prayer[i].length; j++) {
						if(prayer[i][j].equals("2") || prayer[i][j].equals("12")) {
							liikutusClick(robot, pray[i][j][0], pray[i][j][1], 40); //Oikea 40
							prayerTila[i][j] = "X";
							prTila.add(prayerKirja[i][j]);
							if(prayerKirja[i][j] == 4) {
								
								prTila.add(2);
								prTila.add(3);
							}
							if(prayerKirja[i][j] == 2 || prayerKirja[i][j] == 3) {
								prTila.add(4);
							}
							
						}
					}
				}
				pTilaPaivitys(prayerKirja, prayerTila, prayer, pray, prTila, robot);
				
				robot.delay(50);
				robot.mouseMove(s6[0], s6[1]);
				break;
			}
			
			//Pot-up 1
			case 7: { 
				
				potion1[0] = potion1[0] -1;
				if(potion1[0] < 0) {
					System.out.println("Loppu!");
					break;
				}
				sijaVaihto(1, backSijainti, robot);
				int[] s7 = hiiriSijainti();
				if(potion1[0] < 0) {
					System.out.println("Loppu!");
					break;
				}
				for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("P1")){
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							robot.delay(1700);
							if(potion1[0] == 0) {
							items[i][j] = "P10";
							}
						}
					}
				}
				robot.mouseMove(s7[0], s7[1]);
				break;
			}
			
			//Pot-up 2
			case 8: { 
				potion2[0] = potion2[0] -1;
				if(potion2[0] < 0) {
					System.out.println("Loppu!");
					break;
				}
				sijaVaihto(1, backSijainti, robot);
				int[] s8 = hiiriSijainti();
				if(potion2[0] < 0) {
					System.out.println("Loppu!");
					break;
				}
				for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("P2")){
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							robot.delay(1700);
							if(potion2[0] == 0) {
							items[i][j] = "P20";
							}
						}
					}
				}
				robot.mouseMove(s8[0], s8[1]);
				break;
			}

			case 9: break;
			
			 //Lopetus
			case 10: { 
				System.out.println("");
				System.out.println("Lopetus OK!");
				System.exit(1);
			}
			
			//Spec + Gear switch
			case 11: loop1: {
				int[] s11 = hiiriSijainti();
				sijaVaihto(1, backSijainti, robot);
				for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("SP1")){
							if(!sp[0]) {
							robot.delay(30);
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							}
							else {
								robot.delay(0);
								liikutusClick(robot, back[i][j][0], back[i][j][1], 50);
								sp[0] = !sp[0];
								break loop1;
							}
						}
					}
				}
				if(!sp[0]) {
					sijaVaihto(0, backSijainti, robot);
					robot.delay(30);
					liikutusClick(robot, spec[0], spec[1], 0);
					sp[0] = !sp[0];
					robot.delay(0);
					liikutusClick(robot,s11[0], s11[1],45);
					break loop1;
			}
			}
			break;  // Tässä saattaa olla vika jos löytyy spellien kanssa bugi!
			
			//Spell 2
			case 12: {
				int s3[] = hiiriSijainti();
				sijaVaihto(3, backSijainti, robot);
				/*
				 * Ancient
				 */
				if(SB == 2) {
				for(int i = 0; i < 7; ++i) {
					for(int j = 0; j < ancientSB[i].length; ++j) {
						if(ancientSB[i][j] == "2") {
						robot.delay(30);
						liikutusClick(robot,ancient[i][j][0],ancient[i][j][1],0);
					}}
				}}
				else if(SB == 1) {
				/*
				 *Default SB 
				 */
				for(int i = 0; i < 10; ++i) {
					for(int j = 0; j < 7; ++j) {
						if(defSB[i][j] == "2") {
						robot.delay(20);
						liikutusClick(robot,defaultSB[i][j][0],defaultSB[i][j][1],0);
					}}
				}}
				else if(SB == 3) {
				/*
				 * Lunar
				 */
				for(int i = 0; i < 9; ++i) {
					for(int j = 0; j < 5; ++j) {
						if(lunarSB[i][j] == "2") {
						robot.delay(20);
						liikutusClick(robot,lunar[i][j][0],lunar[i][j][1],0);
					}}
				}}
				robot.delay(10);
				liikutusClick(robot, s3[0], s3[1], 35);
				
				break;
			}
			
			//Bank, Reset
			case 13: { 
				
				sijaVaihto(1, backSijainti, robot);
				potion1[0] = 4;
				potion2[0] = 4;
				sp[0] = false;
				for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("P10")){
							items[i][j] = "P1";
						}
						if(items[i][j].equals("P20")){
							items[i][j] = "P2";
						}
						if(items[i][j].equals("F0")){
							items[i][j] = "F" ;
						}
						if(items[i][j].equals("F20")){
							items[i][j] = "F2" ;
						}
					}
				}
				break;
			}
			
			
			//Heal 2
			case 14: { 
				sijaVaihto(1, backSijainti, robot);
				robot.delay(30); 
				int[] s1 = hiiriSijainti();
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("F")){
							
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							
							items[i][j] = "F0";
							
							robot.mouseMove(s1[0], s1[1]);
							robot.delay(20); 
							break loop1;
						}
					}
				}
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("F2")){
							
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							items[i][j] = "F20";
							
							robot.mouseMove(s1[0], s1[1]);
							
							break loop1;
						}
					}
				}
				robot.delay(1700);
				break;
			}
			
			//Panic tele
			case 15: {
				sijaVaihto(1, backSijainti, robot);
				int[] s1 = hiiriSijainti();
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("T")){
							
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							
							robot.mouseMove(s1[0], s1[1]);
							break loop1;
						}
					}
				}
				break;
			}
			
			//Spell 3
			case 16:{
				int s3[] = hiiriSijainti();
				sijaVaihto(3, backSijainti, robot);
				/*
				 * Ancient
				 */
				if(SB == 2) {
				for(int i = 0; i < 7; ++i) {
					for(int j = 0; j < ancientSB[i].length; ++j) {
						if(ancientSB[i][j] == "3") {
						robot.delay(30);
						liikutusClick(robot,ancient[i][j][0],ancient[i][j][1],0);
					}}
				}}
				else if(SB == 1) {
				/*
				 *Default SB 
				 */
				for(int i = 0; i < 10; ++i) {
					for(int j = 0; j < 7; ++j) {
						if(defSB[i][j] == "3") {
						robot.delay(20);
						liikutusClick(robot,defaultSB[i][j][0],defaultSB[i][j][1],0);
					}}
				}}
				else if(SB == 3) {
				/*
				 * Lunar
				 */
				for(int i = 0; i < 9; ++i) {
					for(int j = 0; j < 5; ++j) {
						if(lunarSB[i][j] == "3") {
						robot.delay(20);
						liikutusClick(robot,lunar[i][j][0],lunar[i][j][1],0);
					}}
				}}
				robot.delay(10);
				liikutusClick(robot, s3[0], s3[1], 35);
				
				break;
			}
			
			//Spell 4
			case 17:{
				int s3[] = hiiriSijainti();
				sijaVaihto(3, backSijainti, robot);
				/*
				 * Ancient
				 */
				if(SB == 2) {
				for(int i = 0; i < 7; ++i) {
					for(int j = 0; j < ancientSB[i].length; ++j) {
						if(ancientSB[i][j] == "4") {
						robot.delay(30);
						liikutusClick(robot,ancient[i][j][0],ancient[i][j][1],0);
					}}
				}}
				else if(SB == 1) {
				/*
				 *Default SB 
				 */
				for(int i = 0; i < 10; ++i) {
					for(int j = 0; j < 7; ++j) {
						if(defSB[i][j] == "4") {
						robot.delay(20);
						liikutusClick(robot,defaultSB[i][j][0],defaultSB[i][j][1],0);
					}}
				}}
				else if(SB == 3) {
				/*
				 * Lunar
				 */
				for(int i = 0; i < 9; ++i) {
					for(int j = 0; j < 5; ++j) {
						if(lunarSB[i][j] == "4") {
						robot.delay(20);
						liikutusClick(robot,lunar[i][j][0],lunar[i][j][1],0);
					}}
				}}
				robot.delay(10);
				liikutusClick(robot, s3[0], s3[1], 35);
				
				break;
			}
			
			//Gear switch 2
			case 18: {
				sijaVaihto(1, backSijainti, robot);
				robot.delay(40);
				int[] s2 = hiiriSijainti();
				loop1: for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("S2")){
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							robot.delay(20);
							
						}
					}
				}
				liikutusClick(robot,s2[0], s2[1],40);
				break;
			
			}
			
			//Double Weapon Spec
			//Testattu: Gmaul - AGS, AGS - Gmaul, DDS - Gmaul, DTK - Gmaul, Dclaws - Gmaul
			//Erikoisuudet: Gmaul - Gmaul - Jätä SP2 itemi tyhjäksi 
			//				DBow - DTA - Tarvitaan käyttäjältä click kun DTA spec aktivoitu	
			//Meleellä combo toimii noin 2 laatan välimatkan päästä
			//Huom! SP3 weaponin voi jättää käyttämättä
			case 19: loop1: {
				int[] s11 = hiiriSijainti();
				sijaVaihto(1, backSijainti, robot);
				robot.delay(40);
				for(int i = 0; i < items.length; ++i) {
					for(int j = 0; j < items[i].length; ++j) {
						if(items[i][j].equals("SP1")){
							if(!sp[0]) {
							robot.delay(20); 
							liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							}
							else {
								robot.delay(0);
								liikutusClick(robot, back[i][j][0], back[i][j][1], 50); // 50 toimii
								sp[0] = !sp[0];
								break loop1;
							}
						}
					}
				}
				if(!sp[0]) {
					
					sijaVaihto(0, backSijainti, robot);
					robot.delay(40); //40
					
					liikutusClick(robot, spec[0], spec[1], 0);
					
					liikutusClick(robot,s11[0], s11[1],50); //45-50
					robot.delay(0);
		
					s11 = hiiriSijainti();
					
					sijaVaihto(1, backSijainti, robot);
					robot.delay(40); 
					
					for(int i = 0; i < items.length; ++i) {
						for(int j = 0; j < items[i].length; ++j) {
							if(items[i][j].equals("SP2")){
								liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							}
						}
					}
					
					sijaVaihto(0, backSijainti, robot);
					robot.delay(40); //40
					
					liikutusClick(robot, spec[0], spec[1], 0);
					
					liikutusClick(robot,s11[0], s11[1],50); //45-50
					robot.delay(750); //750 - 350
					
					s11 = hiiriSijainti();
					
					sijaVaihto(1, backSijainti, robot);
					robot.delay(40);
					
					for(int i = 0; i < items.length; ++i) {
						for(int j = 0; j < items[i].length; ++j) {
							if(items[i][j].equals("SP3")){
								robot.delay(750); //750 - 350
								liikutusClick(robot, back[i][j][0], back[i][j][1], 0);
							}
						}
					}
					
					liikutusClick(robot,s11[0], s11[1],45); //45
					robot.delay(200);
					
					//sp[0] = !sp[0];
					
					break loop1;
			}
			}
			break;  // Tässä saattaa olla vika jos löytyy bugi!
			
			}
		}
	});
	}
											//Metodit
//------------------------------------------------------------------------------------------------------//
	
	
// Pyyt�� k�ytt�j�� sijoittamaan hiiren ja palauttaa paikan koordinaatit	
public static int[] kysy(Scanner sc, int nmr) {
	int[] palautus = new int[2];
	System.out.println("Aseta hiiri ja paina Enter..");
	System.out.println("Kalibrointi piste " + nmr + ": ");
	sc.nextLine();
	PointerInfo  mi = MouseInfo.getPointerInfo();
	Point sijainti = mi.getLocation();
	palautus[0] = (int)sijainti.getX();
	palautus[1] = (int)sijainti.getY();
	return palautus;
}	

//Sijoittaa spec baarin sijainnin taulukkoon, vertaillen kalibrointi pisteit�
public static void kalibroiSpec(int[] spec, int[] k1, int[] k2, int[] k3, int[] k4) {
	spec[0] = ((k1[0] + 65) + (k2[0] - 61) + (k3[0] + 65) + (k4[0] - 61)) / 4;
	spec[1] = ((k1[1] + 190) + (k2[1] + 191) + (k3[1] - 25) + (k4[1] - 25)) / 4;
}

//N�p�ytt�� annettua n�pp�int�
public static void napaytys(Robot r, int nappain) {
	
	r.keyPress(nappain);
	r.delay(0);
	r.keyRelease(nappain);
}

//Palauttaa koordinaatteina hiiren t�m�nhetkisen sijainnin
public static int[] hiiriSijainti() {
	int[] palautus = new int[2];
	PointerInfo  mi = MouseInfo.getPointerInfo();
	Point sijainti = mi.getLocation();
	palautus[0] = (int)sijainti.getX();
	palautus[1] = (int)sijainti.getY();
	return palautus;
}

//Tulostaa annetut koordinaatit int[2] 
public static void koordTulostus(int[] koord) {
	System.out.println("X: " + koord[0] + " Y: " + koord[1]);
	System.out.println("");
}

//Liikuttaa hiirt� koordinaattiin ja clickaa
public static void liikutusClick(Robot r, int x, int y , int delay) {
	r.mouseMove(x, y);
	r.delay(delay);
	r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
}

//Tallettaa taulukkon back itemien sijainnit
public static void kalibroiItemit(int[][][] back, int[] k1, int[] k2, int[] k3, int[] k4) {
	back[0][0] = k1;
	back[0][3] = k2;
	back[6][0] = k3;
	back[6][3] = k4;
	for(int i = 1; i < 6; ++i) {
		back[i][0][0] = ( k1[0] + k3[0] ) / 2;
		back[i][0][1] = ( ( (k1[1] + 36*i) + (k3[1] + 36*(i-6)) ) / 2);
		back[i][3][0] = ( k2[0] + k4[0] ) / 2;  
		back[i][3][1] = ( ( (k2[1] + 36*i) + (k4[1] + 36*(i-6)) ) / 2);
	}
	for(int i = 1; i < 3; ++i) {
		back[0][i][1] = ( k1[1] + k2[1] ) / 2;
		back[0][i][0] = ( ( (k1[0] + 42*i) + (k2[0] + 42*(i-3)) ) / 2);
		back[6][i][1] = ( k3[1] + k4[1] ) / 2;
		back[6][i][0] = ( ( (k3[0] + 42*i) + (k4[0] + 42*(i-3)) ) / 2);
	}
	for(int i = 1; i < 6; ++i) {
		back[i][1][0] = ( (k1[0] + 42) + (k3[0] + 42) + (k2[0] - 42*2) + (k4[0] - 42*2) ) / 4; 
		back[i][1][1] = ( (k1[1] + i*36) + (k2[1] + i*36) + (k3[1] + 36*(i-6)) + (k4[1] + 36*(i-6))) / 4;
		back[i][2][0] = ( (k1[0] + 42*2) + (k3[0] + 42*2) + (k2[0] - 42) + (k4[0] - 42) ) / 4; 
		back[i][2][1] = ( (k1[1] + i*36) + (k2[1] + i*36) + (k3[1] + 36*(i-6)) + (k4[1] + 36*(i-6))) / 4;
	}

}

//Tallentaa taulukkoon prayerien sijainnit
public static void kalibroiPrayer(int[][][] pray, int[] k1, int[] k2, int[] k3, int[] k4) {
	
	for(int rivi = 0; rivi < 6; ++rivi) {
		for(int kuvake = 0; kuvake < 5; ++kuvake) {
			if(kuvake == 0 && rivi == 0) {
				pray[rivi][kuvake][0] = ((k1[0]-9) + (k2[0]-135) + (k3[0]-9) + (k4[0]-135)) / 4;
				pray[rivi][kuvake][1] = ((k1[1]+1) + (k2[1]+1) + (k3[1]-215) + (k4[1]-215)) / 4;
			}
			else {
				pray[rivi][kuvake][0] = pray[0][0][0] + (37*kuvake);
				pray[rivi][kuvake][1] = pray[0][0][1] + (37*rivi);
			}
		}
	}
}

//Tallentaa taulukkoon ancient spell bookin sijainnit
public static void kalibroiAncient(int[][][] ancient, int[] k1, int[] k2, int[] k3, int[] k4) {
	
	for(int rivi = 0; rivi < 7; ++rivi) {
		for(int kuvake = 0; kuvake < 4; ++kuvake) {
			if(kuvake == 0 && rivi == 0) {
				ancient[rivi][kuvake][0] = ((k1[0]-7) + (k2[0]-133) + (k3[0]-7) + (k4[0]-133)) / 4;
				ancient[rivi][kuvake][1] = ((k1[1]-14) + (k2[1]-14) + (k3[1]-230) + (k4[1]-230)) / 4;
			}
			else {
				ancient[rivi][kuvake][0] = ancient[0][0][0] + (48*kuvake);
				ancient[rivi][kuvake][1] = ancient[0][0][1] + (36*rivi);
			}
		}
	}
}

//Tallentaa taulukkoon default spell bookin sijainnit
public static void kalibroiDefaultSB(int[][][] defaultSB, int[] k1, int[] k2, int[] k3, int[] k4) {
	
	for(int rivi = 0; rivi < 10; ++rivi) {
		for(int kuvake = 0; kuvake < 7; ++kuvake) {
			if(kuvake == 0 && rivi == 0) {
				defaultSB[rivi][kuvake][0] = ((k1[0]-13) + (k2[0]-139) + (k3[0]-13) + (k4[0]-139)) / 4;
				defaultSB[rivi][kuvake][1] = ((k1[1]-14) + (k2[1]-14) + (k3[1]-230) + (k4[1]-230)) / 4;
			}
			else {
				defaultSB[rivi][kuvake][0] = defaultSB[0][0][0] + (26*kuvake);
				defaultSB[rivi][kuvake][1] = defaultSB[0][0][1] + (24*rivi);
			}
		}
	}
}

//Tallentaa taulukkoon lunar spell bookin sijainnit
public static void kalibroiLunar(int[][][] lunar, int[] k1, int[] k2, int[] k3, int[] k4) {
	
	for(int rivi = 0; rivi < 9; ++rivi) {
		for(int kuvake = 0; kuvake < 5; ++kuvake) {
			if(kuvake == 0 && rivi == 0) {
				lunar[rivi][kuvake][0] = ((k1[0]-15) + (k2[0]-141) + (k3[0]-15) + (k4[0]-141)) / 4;
				lunar[rivi][kuvake][1] = ((k1[1]-14) + (k2[1]-14) + (k3[1]-230) + (k4[1]-230)) / 4;
			}
			else {
				lunar[rivi][kuvake][0] = lunar[0][0][0] + (40*kuvake);
				lunar[rivi][kuvake][1] = lunar[0][0][1] + (27*rivi);
			}
		}
	}
}


//Pit�� kirjaa sijainnista eri v�lilehdiss�
//@Param key: Spec - 0, Back - 1, Pray - 2, Spellbook - 3
public static void sijaVaihto(int key, boolean[] bS, Robot r) {
	if(!bS[key]) {
	for(int i = 0; i < 4; ++i) {
		if(i == key) {
			bS[i] = true;
		
		}
		else {
			bS[i] = false;
		}
	}
	switch (key) {
	case 0: {
		napaytys(r, 112); //F1
		break;
	}
	case 1: {
		napaytys(r, 115); //F4
		break;
	}
	
	case 2: {
		napaytys(r, 116); //F5
		break;
	}
	
	case 3: {
		napaytys(r, 117); //F6
		break;
	}
	
	}
	}
	}

//Done
public static int valitseSB(Scanner lukija) {
	int SB = 0;
	loop1: while(true) {
	System.out.println("Valitse Spell Book tyyppi!");
	System.out.println("");
	System.out.println("Standard - Anna 1 + Enter");
	System.out.println("Ancient - Anna 2 + Enter");
	System.out.println("Lunar - Anna 3 + Enter");
	System.out.println("");
	System.out.println("Valinta:");
	SB = lukija.nextInt(); // 1 - Default, 2 - Ancient, 3 - Lunar
	lukija.nextLine();
	if(SB == 1 || SB == 2 ||SB == 3) {
		break loop1;
	}
	else {
		System.out.println("");
		System.out.println("Virheellinen valinta!");
		System.out.println("");
		continue loop1;
	}
	}
	return SB;
}

public static void pTilaPaivitys(int[][] prayerKirja, String[][] prayerTila, String prayer[][],
												int[][][] pray, ArrayList ar, Robot r) {
	for(int a = 0; a < prayerKirja.length; ++a) {
		loop1: for(int b = 0; b < prayerKirja[a].length; ++b) {
			if(prayerTila[a][b] == "x") {
				prayerTila[a][b] = "";	
						if(ar.contains(prayerKirja[a][b])) {
							ar.remove(new Integer(prayerKirja[a][b]));
							continue loop1;
						}
						liikutusClick(r, pray[a][b][0], pray[a][b][1], 1000);
				
			}
		}
	}
	ar.clear();
}

}