// Copyright (c) 2005 The Legion Of The Bouncy Castle (http://www.bouncycastle.org)
package org.spongycastle.mail.smime.test;

import junit.extensions.TestSetup;
import junit.framework.Test;

import korex.activation.CommandMap;
import korex.activation.MailcapCommandMap;
import java.security.Security;

class SMIMETestSetup extends TestSetup 
{
    private CommandMap originalMap = null;

    public SMIMETestSetup(Test test)
    {
        super(test);
    }

    protected void setUp()
    {
        Security
                .addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());

        MailcapCommandMap _mailcap = (MailcapCommandMap)CommandMap
                .getDefaultCommandMap();

        _mailcap
                .addMailcap("application/pkcs7-signature;; x-java-content-handler=org.spongycastle.mail.smime.handlers.pkcs7_signature");
        _mailcap
                .addMailcap("application/pkcs7-mime;; x-java-content-handler=org.spongycastle.mail.smime.handlers.pkcs7_mime");
        _mailcap
                .addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.spongycastle.mail.smime.handlers.x_pkcs7_signature");
        _mailcap
                .addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.spongycastle.mail.smime.handlers.x_pkcs7_mime");
        _mailcap
                .addMailcap("multipart/signed;; x-java-content-handler=org.spongycastle.mail.smime.handlers.multipart_signed");

        originalMap = CommandMap.getDefaultCommandMap();
        CommandMap.setDefaultCommandMap(_mailcap);
    }

    protected void tearDown()
    {
        CommandMap.setDefaultCommandMap(originalMap);
        originalMap = null;
        Security.removeProvider("BC");
    }


}
