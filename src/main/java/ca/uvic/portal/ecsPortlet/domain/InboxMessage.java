package ca.uvic.portal.ecsPortlet.domain;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * A Domain class for Exchange Channel Inbox Messages. This class works closely
 * with a Digester file that parses a soap response envelope into this
 * domain object.
 * @author Charles Frank
 * @version svn:$Id$
 *
 */
public class InboxMessage {

    /**
     * private message id.
     */
    private String id;
    /**
     * private message owaId.
     */
    private String owaId;
    /**
     * private message subject.
     */
    private String subject;
    /**
     * private message sensitivity.
     */
    private String sensitivity;
    /**
     * private message size.
     */
    private int size;
    /**
     * private message date time created.
     */
    private Date dateTimeCreated;
    /**
     * private Custom formatted month and day value.
     */
    private String dateTimeCreatedMonthDay;
    /**
     * private message date time sent.
     */
    private Date dateTimeSent;
    /**
     * private message has attachments.
     */
    private Boolean hasAttachments;
    /**
     * private message from has attachments flag.
     */
    private String fromMailboxName;
    /**
     * private message is read flag.
     */
    private Boolean isRead;
    /**
     * private soap date format receiving from exchange server.
     */
    private static final String SOAPDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * Constructor default.
     */
    public InboxMessage() { }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }
    /**
     * @param msgId the id to set
     */
    public final void setId(final String msgId) {
        this.id = msgId;
    }
    /**
     * @return the owaId
     */
    public final String getOwaId() {
        return owaId;
    }
    /**
     * @param oId owaId to set
     */
    public final void setOwaId(final String oId) {
        this.owaId = oId;
    }

    /**
     * @return the subject
     */
    public final String getSubject() {
        return subject;
    }
    /**
     * @param msgSubject the subject to set
     */
    public final void setSubject(final String msgSubject) {
        this.subject = msgSubject;
    }
    /**
     * @return the sensitivity
     */
    public final String getSensitivity() {
        return sensitivity;
    }
    /**
     * @param msgSensitivity the sensitivity to set
     */
    public final void setSensitivity(final String msgSensitivity) {
        this.sensitivity = msgSensitivity;
    }
    /**
     * @return the size
     */
    public final int getSize() {
        return size;
    }
    /**
     * @param msgSize the size to set
     */
    public final void setSize(final int msgSize) {
        this.size = msgSize;
    }
    /**
     * @param format a string in the format required by SimpleDateFormat
     * @return the SimpleDateFormat manipulated string
     */
    public final String getDateTimeSent(final String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(this.dateTimeSent);
    }
    /**
     * @param timeSent string to create a Date object with
     * @throws ParseException a parse exception
     */
    public final void setDateTimeSent(final String timeSent)
        throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(SOAPDATEFORMAT);
        Date messageDate = sdf.parse(timeSent);
        this.dateTimeSent = messageDate;
    }
    /**
     * @param format a string in the format required by SimpleDateFormat
     * @return the SimpleDateFormat manipulated string
     */
    public final String getDateTimeCreated(final String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(this.dateTimeCreated);
    }
    /**
     * @param timeCreated string to create Date object with
     * @throws ParseException a parse exception
     */
    public final void setDateTimeCreated(final String timeCreated)
        throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(SOAPDATEFORMAT);
        Date createdDate = sdf.parse(timeCreated);
        this.dateTimeCreated = createdDate;
        //Add in any other custom date formats here, and then create
        //a private property and getter method, useful w/jsp&EL.
        this.dateTimeCreatedMonthDay = this.getDateTimeCreated("MMM d");
    }
    /**
     * Helper method to return a custom formatted date 'MMM d', example 'May 6'.
     * @return Formatted date similar to 'May 6' or 'June 22'
     * @see SimpleDateFormat MMM d
     */
    public final String getDateTimeCreatedMonthDay() {
        return this.dateTimeCreatedMonthDay;
    }
    /**
     * @return the attachments flag
     */
    public final Boolean getHasAttachments() {
        return hasAttachments;
    }
    /**
     * @param attachments the attachments flag to set
     */
    public final void setHasAttachments(final Boolean attachments) {
        this.hasAttachments = attachments;
    }
    /**
     * @return the fromMailboxName
     */
    public final String getFromMailboxName() {
        return fromMailboxName;
    }
    /**
     * @param fromMboxName the fromMailboxName to set
     */
    public final void setFromMailboxName(final String fromMboxName) {
        this.fromMailboxName = fromMboxName;
    }
    /**
     * @return the isRead
     */
    public final Boolean getIsRead() {
        return isRead;
    }
    /**
     * @param read the has been read flag to set
     */
    public final void setIsRead(final Boolean read) {
        this.isRead = read;
    }

}
