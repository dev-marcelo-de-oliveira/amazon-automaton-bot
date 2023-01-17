package br.dev.marcelodeoliveira.amazonautomatonbot.utils;

import java.util.StringJoiner;

public class DomainUtils {

	private static String urlSeparator = ".";
	private static String baseUrlPrefix = "https://amazon";

	public static enum InstitutionalDomains {
		CO("co"), COM("com"), EDU("edu"), NET("net"), ORG("org");

		private String stringValue;

		InstitutionalDomains(String stringValue) {
			this.stringValue = stringValue;
		}
	}

	public String HomeUrlBuilderByCountry(Countries country) {
		return new StringJoiner(urlSeparator)
				.add(baseUrlPrefix)
				.add(country.getSuffix(country))
				.toString();
	}

	public static enum Countries {
		/*
		 * Afghanistan("AF"), AlandIslands("AX"), Albania("AL"), Algeria("DZ"),
		 * AmericanSamoa("AS"), Andorra("AD"), Angola("AO"), Anguilla("AI"),
		 * Antarctica("AQ"), AntiguaAndBarbuda("AG"), Argentina("AR"), Armenia("AM"),
		 * Aruba("AW"),
		 */ Australia("AU"),

		/*
		 * Austria("AT"), Azerbaijan("AZ"), Bahamas("BS"), Bahrain("BH"),
		 * Bangladesh("BD"), Barbados("BB"), Belarus("BY"),
		 */
		Belgium("BE"),
		/*
		 * Belize("BZ"), Benin("BJ"), Bermuda("BM"), Bhutan("BT"), Bolivia("BO"),
		 * BonaireSintEustatiusSaba("BQ"), BosniaAndHerzegovina("BA"), Botswana("BW"),
		 * BouvetIsland("BV"),
		 */
		Brazil("BR"),
		/*
		 * BritishIndianOceanTerritory("IO"), BruneiDarussalam("BN"), Bulgaria("BG"),
		 * BurkinaFaso("BF"), Burundi("BI"), Cambodia("KH"), Cameroon("CM"),
		 */
		Canada("CA"),

		/*
		 * CapeVerde("CV"), CaymanIslands("KY"), CentralAfricanRepublic("CF"),
		 * Chad("TD"), Chile("CL"),
		 */
		China("CN"),
		/*
		 * ChristmasIsland("CX"), CocosKeelingIslands("CC"), Colombia("CO"),
		 * Comoros("KM"), Congo("CG"), CongoDemocraticRepublic("CD"), CookIslands("CK"),
		 * CostaRica("CR"), CoteDIvoire("CI"), Croatia("HR"), Cuba("CU"), Curaçao("CW"),
		 * Cyprus("CY"), CzechRepublic("CZ"), Denmark("DK"), Djibouti("DJ"),
		 * Dominica("DM"), DominicanRepublic("DO"), Ecuador("EC"),
		 */
		Egypt("EG"),
		/*
		 * ElSalvador("SV"), EquatorialGuinea("GQ"), Eritrea("ER"), Estonia("EE"),
		 * Ethiopia("ET"), FalklandIslands("FK"), FaroeIslands("FO"), Fiji("FJ"),
		 * Finland("FI"),
		 */
		France("FR"),
		/*
		 * FrenchGuiana("GF"), FrenchPolynesia("PF"), FrenchSouthernTerritories("TF"),
		 * Gabon("GA"), Gambia("GM"), Georgia("GE"),
		 */
		Germany("DE"),
		/*
		 * Ghana("GH"), Gibraltar("GI"), Greece("GR"), Greenland("GL"), Grenada("GD"),
		 * Guadeloupe("GP"), Guam("GU"), Guatemala("GT"), Guernsey("GG"), Guinea("GN"),
		 * GuineaBissau("GW"), Guyana("GY"), Haiti("HT"),
		 * HeardIslandMcdonaldIslands("HM"), HolySeeVaticanCityState("VA"),
		 * Honduras("HN"), HongKong("HK"), Hungary("HU"), Iceland("IS"),
		 */
		India("IN"),
		/*
		 * Indonesia("ID"), Iran("IR"), Iraq("IQ"), Ireland("IE"), IsleOfMan("IM"),
		 * Israel("IL"),
		 */
		Italy("IT"), Jamaica("JM"),

		Japan("JP"),
		/*
		 * Jersey("JE"), Jordan("JO"), Kazakhstan("KZ"), Kenya("KE"), Kiribati("KI"),
		 * Korea("KR"), KoreaDemocraticPeoplesRepublic("KP"), Kuwait("KW"),
		 * Kyrgyzstan("KG"), LaoPeoplesDemocraticRepublic("LA"), Latvia("LV"),
		 * Lebanon("LB"), Lesotho("LS"), Liberia("LR"), LibyanArabJamahiriya("LY"),
		 * Liechtenstein("LI"), Lithuania("LT"), Luxembourg("LU"), Macao("MO"),
		 * Macedonia("MK"), Madagascar("MG"), Malawi("MW"), Malaysia("MY"),
		 * Maldives("MV"), Mali("ML"), Malta("MT"), MarshallIslands("MH"),
		 * Martinique("MQ"), Mauritania("MR"), Mauritius("MU"), Mayotte("YT"),
		 */
		Mexico("MX"),
		/*
		 * Micronesia("FM"), Moldova("MD"), Monaco("MC"), Mongolia("MN"),
		 * Montenegro("ME"), Montserrat("MS"), Morocco("MA"), Mozambique("MZ"),
		 * Myanmar("MM"), Namibia("NA"), Nauru("NR"), Nepal("NP"),
		 */
		Netherlands("NL"),
		/*
		 * NewCaledonia("NC"), NewZealand("NZ"), Nicaragua("NI"), Niger("NE"),
		 * Nigeria("NG"), Niue("NU"), NorfolkIsland("NF"), NorthernMarianaIslands("MP"),
		 * Norway("NO"), Oman("OM"), Pakistan("PK"), Palau("PW"),
		 * PalestinianTerritory("PS"), Panama("PA"), PapuaNewGuinea("PG"),
		 * Paraguay("PY"), Peru("PE"), Philippines("PH"), Pitcairn("PN"),
		 */
		Poland("PL"),
		/*
		 * Portugal("PT"), PuertoRico("PR"), Qatar("QA"), Reunion("RE"), Romania("RO"),
		 * RussianFederation("RU"), Rwanda("RW"), SaintBarthelemy("BL"),
		 * SaintHelena("SH"), SaintKittsAndNevis("KN"), SaintLucia("LC"),
		 * SaintMartin("MF"), SaintPierreAndMiquelon("PM"),
		 * SaintVincentAndGrenadines("VC"), Samoa("WS"), SanMarino("SM"),
		 * SaoTomeAndPrincipe("ST"),
		 */
		SaudiArabia("SA"),
		/*
		 * Senegal("SN"), Serbia("RS"), Seychelles("SC"), SierraLeone("SL"),
		 */
		Singapore("SG"),
		/*
		 * SaintMaarten("SX"), Slovakia("SK"), Slovenia("SI"), SolomonIslands("SB"),
		 * Somalia("SO"), SouthAfrica("ZA"), SouthGeorgiaAndSandwichIsl("GS"),
		 * SouthSudan("SS"),
		 */
		Spain("ES"),
		/*
		 * SriLanka("LK"), Sudan("SD"), Suriname("SR"), SvalbardAndJanMayen("SJ"),
		 * Swaziland("SZ"),
		 */
		Sweden("SE"),
		/*
		 * Switzerland("CH"), SyrianArabRepublic("SY"), Taiwan("TW"), Tajikistan("TJ"),
		 * Tanzania("TZ"), Thailand("TH"), TimorLeste("TL"), Togo("TG"), Tokelau("TK"),
		 * Tonga("TO"), TrinidadAndTobago("TT"), Tunisia("TN"),
		 */
		Turkey("TR"),
		/*
		 * Turkmenistan("TM"), TurksAndCaicosIslands("TC"), Tuvalu("TV"), Uganda("UG"),
		 * Ukraine("UA"),
		 */
		UnitedArabEmirates("AE"), UnitedKingdom("GB"), UnitedStates("US")
		/*
		 * UnitedStatesOutlyingIslands("UM"), Uruguay("UY"), Uzbekistan("UZ"),
		 * Vanuatu("VU"), Venezuela("VE"), Vietnam("VN"), VirginIslandsBritish("VG"),
		 * VirginIslandsUS("VI"), WallisAndFutuna("WF"), WesternSahara("EH"),
		 * Yemen("YE"), Zambia("ZM"), Zimbabwe("ZW"),
		 */

		;

		public String dotCoOrDotCom(Countries country) {
			switch (country) {
			case Japan:
			case UnitedKingdom:
				return InstitutionalDomains.CO.stringValue;
			default:
				return InstitutionalDomains.COM.stringValue;
			}
		}

		public String getSuffix(Countries country) {

			var suffix = dotCoOrDotCom(country).concat(urlSeparator);
			var isoName = country.countryIsoTwoCharName;

			if (!isoName.equals("US")) {
				suffix += isoName;
			}

			return suffix;
		}

		private String countryIsoTwoCharName;

		Countries(String countryIsoTwoCharName) {
			this.setCountryName(countryIsoTwoCharName);

		}

		public String getCountryName() {
			return countryIsoTwoCharName;
		}

		private void setCountryName(String countryName) {
			this.countryIsoTwoCharName = countryName;
		}
	}

}
