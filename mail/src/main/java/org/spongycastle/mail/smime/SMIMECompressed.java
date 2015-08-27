package org.spongycastle.mail.smime;

import java.io.IOException;
import java.io.InputStream;

import org.spongycastle.cms.CMSCompressedData;
import org.spongycastle.cms.CMSException;

import korex.mail.MessagingException;
import korex.mail.Part;
import korex.mail.internet.MimeBodyPart;
import korex.mail.internet.MimeMessage;
import korex.mail.internet.MimePart;

/**
 * containing class for an S/MIME pkcs7-mime MimePart.
 */
public class SMIMECompressed
    extends CMSCompressedData
{
    MimePart message;

    private static InputStream getInputStream(
        Part bodyPart)
        throws MessagingException
    {
        try
        {
            return bodyPart.getInputStream();
        }
        catch (IOException e)
        {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    public SMIMECompressed(
        MimeBodyPart message)
        throws MessagingException, CMSException
    {
        super(getInputStream(message));

        this.message = message;
    }

    public SMIMECompressed(
        MimeMessage message)
        throws MessagingException, CMSException
    {
        super(getInputStream(message));

        this.message = message;
    }

    public MimePart getCompressedContent()
    {
        return message;
    }
}
