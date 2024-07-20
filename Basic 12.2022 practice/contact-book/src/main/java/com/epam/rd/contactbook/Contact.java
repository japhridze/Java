package com.epam.rd.contactbook;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String contactName;
    private String phoneNumber;
    private Email[] email = new Email[3];
    private Social[] social = new Social[5];
    private ContactInfo[] contactInfoList = new ContactInfo[5];
    private int emailCount = 0;
    private int socialCount = 0;
    private int contactInfoCount = 0;

    public static void main(String[] args) {
        Contact C1 = new Contact("g");

        System.out.println(C1.addEpamEmail("top", "G").getValue());
        System.out.println(C1.addEpamEmail("top", "G").getTitle());

        ContactInfo[] info = C1.getInfo();

        System.out.println(info[0].getTitle());
        System.out.println(info[0].getValue());
    }

    public Email addEmail(String localPart, String domain) {
        if (emailCount < 3) {
            Email em = new Email(localPart, domain);
            email[emailCount++] = em;
            return em;
        }
        return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (emailCount < 3) {
            Email epamEmail = new Email(firstname + "_" + lastname, "epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            email[emailCount++] = epamEmail;
            return epamEmail;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phoneNumber == null) {
            phoneNumber = "+" + code + " " + number;
            return new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return phoneNumber;
                }
            };
        }
        return null;
    }

    public Social addTwitter(String twitterId) {
        if (socialCount < 5) {
            Social s = new Social("Twitter", twitterId);
            social[socialCount++] = s;
            return s;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        if (socialCount < 5) {
            Social s = new Social("Instagram", instagramId);
            social[socialCount++] = s;
            return s;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        if (socialCount < 5) {
            Social s = new Social(title, id);
            social[socialCount++] = s;
            return s;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        contactInfoCount = 1;

        if (phoneNumber != null) {
            contactInfoCount++;
        }

        for (int i = 0; i < emailCount; i++) {
            contactInfoCount++;
        }

        for (int i = 0; i < socialCount; i++) {
            contactInfoCount++;
        }

        ContactInfo[] result = new ContactInfo[contactInfoCount];

        int index = 0;
        result[index++] = new NameContactInfo();

        if (phoneNumber != null) {
            result[index++] = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return phoneNumber;
                }
            };
        }

        for (int i = 0; i < emailCount; i++) {
            result[index++] = email[i];
        }

        for (int i = 0; i < socialCount; i++) {
            result[index++] = social[i];
        }

        return result;
    }

    public Contact(String contactName) {
        if (contactName != null && !contactName.isEmpty()) {
            this.contactName = contactName;
        }
    }

    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.contactName = newName;
        }
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private String email;

        public Email(String localPart, String email) {
            this.email = localPart + "@" + email;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo {
        private String title;
        private String link;

        public Social(String title, String link) {
            this.title = title;
            this.link = link;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return link;
        }
    }
}
