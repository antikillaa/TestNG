package BO.testData;

import org.apache.commons.lang3.RandomStringUtils;

public class logins {

    public static String AccessKeyDev_IBUSER = new String( "8060dc33-8a27-4bcd-8561-b4cd09c2337b" );
    public static String LoginDev_IBUSER = new String( "dev_IBUSER" );
    public static String PasswordDev_IBUSER = new String( "dev_QaZ321!" );

    public static String AccessKeySuperadmin = new String( "aaa11200-19f1-48c1-a78c-3a3d56095f38" );
    public static String LoginSuperAdmin = new String( "SUPERADMIN" );
    public static String PasswordSuperAdmin = new String( "SUPERadmin777" );

    public static String Domain = new String( "example.com" );
    public static String AffiliateID = RandomStringUtils.randomNumeric(10).toLowerCase();;

    public static String RandomName = RandomStringUtils.randomAlphanumeric(20).toLowerCase();

}