package org.spongycastle.mail.smime.handlers;

import kore.awt.datatransfer.DataFlavor;

import korex.activation.ActivationDataFlavor;
import korex.mail.internet.MimeBodyPart;

public class pkcs7_signature
    extends PKCS7ContentHandler
{
    private static final ActivationDataFlavor ADF = new ActivationDataFlavor(MimeBodyPart.class, "application/pkcs7-signature", "Signature");
    private static final DataFlavor[]         DFS = new DataFlavor[] { ADF };
    
    public pkcs7_signature()
    {
        super(ADF, DFS);
    }
}
