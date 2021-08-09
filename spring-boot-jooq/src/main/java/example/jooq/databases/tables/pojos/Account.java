/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String        id;
    private final String        email;
    private final String        name;
    private final String        phoneNumber;
    private final Byte          confirmedAndActive;
    private final LocalDateTime memberSince;
    private final String        passwordHash;
    private final String        photoUrl;
    private final Byte          support;

    public Account(Account value) {
        this.id = value.id;
        this.email = value.email;
        this.name = value.name;
        this.phoneNumber = value.phoneNumber;
        this.confirmedAndActive = value.confirmedAndActive;
        this.memberSince = value.memberSince;
        this.passwordHash = value.passwordHash;
        this.photoUrl = value.photoUrl;
        this.support = value.support;
    }

    public Account(
        String        id,
        String        email,
        String        name,
        String        phoneNumber,
        Byte          confirmedAndActive,
        LocalDateTime memberSince,
        String        passwordHash,
        String        photoUrl,
        Byte          support
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.confirmedAndActive = confirmedAndActive;
        this.memberSince = memberSince;
        this.passwordHash = passwordHash;
        this.photoUrl = photoUrl;
        this.support = support;
    }

    /**
     * Getter for <code>mydb.account.id</code>.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Getter for <code>mydb.account.email</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for <code>mydb.account.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>mydb.account.phone_number</code>.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for <code>mydb.account.confirmed_and_active</code>.
     */
    public Byte getConfirmedAndActive() {
        return this.confirmedAndActive;
    }

    /**
     * Getter for <code>mydb.account.member_since</code>.
     */
    public LocalDateTime getMemberSince() {
        return this.memberSince;
    }

    /**
     * Getter for <code>mydb.account.password_hash</code>.
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Getter for <code>mydb.account.photo_url</code>.
     */
    public String getPhotoUrl() {
        return this.photoUrl;
    }

    /**
     * Getter for <code>mydb.account.support</code>.
     */
    public Byte getSupport() {
        return this.support;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Account (");

        sb.append(id);
        sb.append(", ").append(email);
        sb.append(", ").append(name);
        sb.append(", ").append(phoneNumber);
        sb.append(", ").append(confirmedAndActive);
        sb.append(", ").append(memberSince);
        sb.append(", ").append(passwordHash);
        sb.append(", ").append(photoUrl);
        sb.append(", ").append(support);

        sb.append(")");
        return sb.toString();
    }
}