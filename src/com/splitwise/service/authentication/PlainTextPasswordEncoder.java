package com.splitwise.service.authentication;

public class PlainTextPasswordEncoder implements PasswordEncoder{
    private static PlainTextPasswordEncoder INS;
    private PlainTextPasswordEncoder(){}

    private static final class InstanceHolder {


        private static final PlainTextPasswordEncoder INSTANCE = new PlainTextPasswordEncoder();
    }

    public static PlainTextPasswordEncoder getInstance(){
        return InstanceHolder.INSTANCE;
    }



    public static PlainTextPasswordEncoder getNewInstance() {
        if (INS == null) {
            synchronized (PlainTextPasswordEncoder.class) {
                if (INS == null) {
                    INS = new PlainTextPasswordEncoder();
                }
            }
        }
        return INS;
    }




    @Override
    public String encode(String password, String userName) {
        return password;
    }


}
