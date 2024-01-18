package com.example.formvalidation.model;

import java.util.ArrayList;
import java.util.Date;

public class GoogleBook {

    public GoogleBook() {
    }

    public static class AccessInfo{
        public String country;
        public String viewability;
        public boolean embeddable;
        public boolean publicDomain;
        public String textToSpeechPermission;
        public Epub epub;
        public Pdf pdf;
        public String webReaderLink;
        public String accessViewStatus;
        public boolean quoteSharingAllowed;
    }

    public static class Epub{
        public boolean isAvailable;
        public String acsTokenLink;
    }

    public static class ImageLinks{
        public String smallThumbnail;
        public String thumbnail;
    }

    public static class IndustryIdentifier{
        public String type;
        public String identifier;
    }

    public static class ListPrice{
        public double amount;
        public String currencyCode;
        public int amountInMicros;
    }

    public static class Offer{
        public int finskyOfferType;
        public ListPrice listPrice;
        public RetailPrice retailPrice;
    }

    public static class PanelizationSummary{
        public boolean containsEpubBubbles;
        public boolean containsImageBubbles;
    }

    public static class Pdf{
        public boolean isAvailable;
        public String acsTokenLink;
    }

    public static class ReadingModes{
        public boolean text;
        public boolean image;
    }

    public static class RetailPrice{
        public double amount;
        public String currencyCode;
        public int amountInMicros;
    }

    public static class Root{
        public Root() {

        }

        public String kind;
        public String id;
        public String etag;
        public String selfLink;
        public VolumeInfo volumeInfo;
        public SaleInfo saleInfo;
        public AccessInfo accessInfo;
        public SearchInfo searchInfo;
    }

    public static class  SaleInfo{
        public String country;
        public String saleability;
        public boolean isEbook;
        public ListPrice listPrice;
        public RetailPrice retailPrice;
        public String buyLink;
        public ArrayList<Offer> offers;
    }

    public static class SearchInfo{
        public String textSnippet;
    }

    public static class VolumeInfo{
        public String title;
        public ArrayList<String> authors;
        public String publisher;
        public Date publishedDate;
        public String description;
        public ArrayList<IndustryIdentifier> industryIdentifiers;
        public ReadingModes readingModes;
        public int pageCount;
        public String printType;
        public ArrayList<String> categories;
        public int averageRating;
        public int ratingsCount;
        public String maturityRating;
        public boolean allowAnonLogging;
        public String contentVersion;
        public PanelizationSummary panelizationSummary;
        public ImageLinks imageLinks;
        public String language;
        public String previewLink;
        public String infoLink;
        public String canonicalVolumeLink;
    }



}
