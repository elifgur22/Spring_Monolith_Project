package com.elif.utility.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";

    private static final String ROOT = DEV + VERSION;
    public static final String HASTA = ROOT + "/hasta";
    public static final String DOKTOR = ROOT + "/doktor";
    public static final String RANDEVU = ROOT + "/randevu";
    public static final String AUTH = ROOT + "/auth";

    public static final String ADD = "/add";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String GET_RANDEVULAR_BY_DOKTOR_INFO = "/get-randevular-by-doktor-adi-soyadi";
    public static final String REGISTER = "/register";

}
