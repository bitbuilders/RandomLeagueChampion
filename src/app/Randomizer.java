package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Randomizer {
	
	private static String item1 = "";
	private static String item2 = "";
	private static String item3 = "";
	private static String item4 = "";
	private static String item5 = "";
	private static String item6 = "";
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static String[] allCharacters;
	private static String[] allItems;
	
	public static void main(String[] args) throws IOException {
		addStuff();
		System.out.println("Welcome to League of Random!");
		System.out.println("Here you can get random champions and builds for you to play with!");
		prompt();
	}
	
	public static void prompt() throws IOException {
		System.out.println("Do you want your champion to be male, female, or either? (Type in the number)");
		System.out.println("1. Male");
		System.out.println("2. Female");
		System.out.print("3. Either ");
		String gender = reader.readLine().replace(" ", "");
		int gen = Integer.parseInt(gender);
		
		System.out.println("");
		System.out.println("Next, do you want to have a random item build associated with that champion? "
				+ "(Type in the number)");
		System.out.println("1. Yes");
		System.out.print("2. No ");
		String giveBuild = reader.readLine().replace(" ", "");
		int build = Integer.parseInt(giveBuild);
		System.out.println("Randomizing Champions...");
		System.out.println("");
		generateChampion(gen, build);
	}
	
	public static void generateChampion(int gender, int giveBuild) throws IOException {
		String currentChamp = "";
		String randChamp = "";
		do{
			Random random = new Random();
			randChamp = allCharacters[random.nextInt(allCharacters.length)];
			if (randChamp.endsWith("M")) {
				if (gender == 1) {
					currentChamp = randChamp;
				}
				else if (gender == 2) {
					currentChamp = "";
				}
				else {
					currentChamp = randChamp;
				}
			}
			else {
				if (gender == 1) {
					currentChamp = "";
				}
				else if (gender == 2) {
					currentChamp = randChamp;
				}
				else {
					currentChamp = randChamp;
				}
			}
		}while(currentChamp.equals(""));
		
		currentChamp = currentChamp.substring(0, currentChamp.length() - 1);
		
		do{
			Random random = new Random();
			String randItem = allItems[random.nextInt(allItems.length)];
			if (giveBuild == 1) {
				if (randItem.endsWith("B") && item1.equals("")) {
					item1 = randItem;
				}
				else if (randItem.endsWith("R") && item2.equals("") && !item1.equals("")) {
					item2 = randItem;
				}
				else if (item3.equals("") && !item2.equals("") && !item3.endsWith("R") && !item3.endsWith("B")) {
					item3 = randItem;
				}
				else if (item4.equals("") && !item3.equals("") && !item4.endsWith("R") && !item4.endsWith("B")) {
					item4 = randItem;
				}
				else if (item5.equals("") && !item4.equals("") && !item5.endsWith("R") && !item5.endsWith("B")) {
					item5 = randItem;
				}
				else if (item6.equals("") && !item5.equals("") && !item6.endsWith("R") && !item6.endsWith("B")) {
					item6 = randItem;
					
					item1 = item1.substring(0, item1.length() - 1);
					item2 = item2.substring(0, item2.length() - 1);
					item3 = item3.substring(0, item3.length() - 1);
					item4 = item4.substring(0, item4.length() - 1);
					item5 = item5.substring(0, item5.length() - 1);
					item6 = item6.substring(0, item6.length() - 1);
				}
				else {
					item6 = "";
				}
			}
			else {
				item6 = " ";
			}
		}while(item6.equals(""));
		
		output(currentChamp);
	}
	
	public static void output(String champ) throws IOException {
		System.out.println("Your random champion to play is: " + champ);
		if (!item6.equals(" ")) {
			System.out.println("Your random build is:");
			System.out.println("* " + item1);
			System.out.println("* " + item2);
			System.out.println("* " + item3);
			System.out.println("* " + item4);
			System.out.println("* " + item5);
			System.out.println("* " + item6);
			System.out.println("");
			System.out.println("You can buy potions any time you wish, and you can get any item as long as "
					+ "it is a component to your final item.");
			System.out.println("You do not have to get your items in any specific order. And once you have every item, "
					+ "you can replace the first item listed with anything you want.");
			System.out.println("If you got Cassiopeia, you can pick any item you want instead of boots.");
			System.out.println("Once you have all other items completed, you can replace all the starting items with one of your choice.");
		}
		else {
			System.out.println("Since you didn't want a random build, you're not getting one.");
		}
		System.out.println("");
		
		item1 = "";
		item2 = "";
		item3 = "";
		item4 = "";
		item5 = "";
		item6 = "";
		
		boolean isValid = false;
		do {
		System.out.println("Do you want to get another random champion/build? (Type in the number)");
		System.out.println("1. Yes");
		System.out.print("2. No ");
		String input = reader.readLine().replace(" ", "");
		System.out.println("");
		
		if (input.equals("1")) {
			isValid = true;
			prompt();
		}
		else if (input.equals("2")) {
			isValid = true;
			System.out.println("Closing Application...");
		}
		else {
			System.out.println("ERROR: Please enter a valid number.");
			isValid = false;
		}
		}while(!isValid);
	}
	
	public static void addStuff() {
		allCharacters = new String[]{
				"AatroxM",
				"AhriF",
				"AkaliF",
				"AlistarM",
				"AmumuM",
				"AniviaF",
				"AnnieF",
				"AsheF",
				"Aurelion SolM",
				"AzirM",
				"BardM",
				"BlitzcrankM",
				"BrandM",
				"BraumM",
				"CaitlynF",
				"CassiopeiaF",
				"Cho'GathM",
				"CorkiM",
				"DariusM",
				"DianaF",
				"Dr. MundoM",
				"DravenM",
				"EkkoM",
				"EliseF",
				"EvelynnF",
				"EzrealM",
				"FiddlesticksM",
				"FioraF",
				"FizzM",
				"GalioM",
				"GangplankM",
				"GarenM",
				"GnarM",
				"GragasM",
				"GravesM",
				"HecarimM",
				"HeimerdingerM",
				"IllaoiF",
				"IreliaF",
				"IvernM",
				"JannaF",
				"Jarvan IVM",
				"JaxM",
				"JayceM",
				"JhinM",
				"JinxF",
				"KalistaF",
				"KarmaF",
				"KarthusM",
				"KassadinM",
				"KatarinaF",
				"KayleF",
				"KennenM",
				"Kha'ZixM",
				"KindredF",
				"KledM",
				"Kog'MawM",
				"LeBlancF",
				"Lee SinM",
				"LeonaF",
				"LissandraF",
				"LucianM",
				"Miss FortuneF",
				"MordekaiserM",
				"MorganaF",
				"NamiF",
				"NasusM",
				"NautilusM",
				"NidaleeF",
				"NocturneM",
				"NunuM",
				"OlafM",
				"OriannaF",
				"PantheonM",
				"PoppyF",
				"QuinnF",
				"RammusM",
				"Rek'SaiF",
				"RenektonM",
				"RengarM",
				"RivenF",
				"RumbleM",
				"RyzeM",
				"SejuaniF",
				"ShacoM",
				"ShenM",
				"ShyvanaF",
				"SingedM",
				"SionM",
				"SivirF",
				"SkarnerM",
				"SonaF",
				"SorakaF",
				"SwainM",
				"SyndraF",
				"Tahm KenchM",
				"TaliyahF",
				"TalonM",
				"TaricM",
				"TeemoM",
				"ThreshM",
				"TristanaM",
				"TrundleM",
				"TryndamereM",
				"Twisted FateM",
				"TwitchM",
				"UdyrM",
				"UrgotM",
				"VarusM",
				"VayneF",
				"VeigarM",
				"Vel'KozM",
				"ViF",
				"ViktorM",
				"VladimirM",
				"VolibearM",
				"WarwickM",
				"WukongM",
				"XerathM",
				"Xin ZhaoM",
				"YasuoM",
				"YorickM",
				"ZacM",
				"ZedM",
				"ZiggsM",
				"ZileanM",
				"ZyraM"
		};
		allItems = new String[] {
				"Abyssal ScepterA",
				"Archangel's StaffA",
				"Ardent CenserS",
				"Athene's Unholy GrailA",
				"Banner of CommandS",
				"Banshee's VeilT",
				"Berserker's GreavesR",
				"Blade of the Ruined KingD",
				"Boots of MobilityR",
				"Boots of SwiftnessR",
				"Corrupting PotionB",
				"CullB",
				"Dead Man's PlateT",
				"Death's DanceD",
				"Doran's BladeB",
				"Doran's RingB",
				"Doran's ShieldB",
				"Duskblade of DarktharrD",
				"Elixir of IronP",
				"Elixir of SorceryP",
				"Elixir of WrathP",
				"Essence ReaverD",
				"Eye of the EquinoxS",
				"Eye of the OasisS",
				"Eye of the WatchersS",
				"Face of the MountainS",
				"Farsight AlterationK",
				"Frost Queen's ClaimS",
				"Frozen HeartT",
				"Frozen MalletD",
				"Guardian AngelT",
				"Guinsoo's RagebladeD",
				"Hextech GLP-800A",
				"Hextech GunbladeA",
				"Hextech Protobelt-01A",
				"Hunter's MacheteJ",
				"Hunter's PotionJ",
				"Hunter's TalismanJ",
				"Iceborn GauntletT",
				"Infinity EdgeD",
				"Ionian Boots of LucidityR",
				"Liandry's TormentA",
				"Lich BaneA",
				"Locket of the Iron SolariS",
				"Lord Dominik's RegardsD",
				"Luden's EchoA",
				"ManamuneD",
				"Maw of MalmortiusD",
				"Mejai's SoulstealerA",
				"Mercurial ScimitarD",
				"Mercury's TreadsR",
				"Mikael's CrucibleS",
				"MorellonomiconA",
				"Mortal ReminderD",
				"Nashor's ToothA",
				"Ninja TabiR",
				"OhmwreckerT",
				"Oracle AlterationK",
				"Phantom DancerD",
				"Rabadon's DeathcapA",
				"Randuin's OmenT",
				"Rapid FirecannonD",
				"Ravenous HydraD",
				"Righteous GloryT",
				"Rod of AgesA",
				"Runaan's HurricaneD",
				"Rylai's Crystal ScepterA",
				"Sorcerer's ShoesR",
				"Spirit VisageT",
				"Skirmisher's SabreJ",
				"Stalker's BladeJ",
				"Statikk ShivD",
				"Sterak's GageT",
				"Sunfire CapeT",
				"Talisman of AscensionS",
				"The Black CleaverD",
				"The BloodthirsterD",
				"The Dark SealB",
				"ThornmailT",
				"Titanic HydraD",
				"Tracker's KnifeJ",
				"Trinity ForceD",
				"Void StaffA",
				"Warmog's ArmorT",
				"Wit's EndD",
				"Youmuu's GhostbladeD",
				"Zeke's HarbingerS",
				"Zhonya's HourglassA",
				"Zz'Rot PortalT"
		};
	}
}
