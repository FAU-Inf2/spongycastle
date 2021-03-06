package org.spongycastle.mail.smime.handlers;

import kore.awt.datatransfer.DataFlavor;

import korex.activation.ActivationDataFlavor;
import korex.mail.internet.MimeBodyPart;

public class x_pkcs7_mime 
    extends PKCS7ContentHandler
{
    private static final ActivationDataFlavor ADF = new ActivationDataFlavor(MimeBodyPart.class, "application/x-pkcs7-mime", "Encrypted Data");
    private static final DataFlavor[]         DFS = new DataFlavor[] { ADF };
    
    public x_pkcs7_mime()
    {
        super(ADF, DFS);
    }
}
