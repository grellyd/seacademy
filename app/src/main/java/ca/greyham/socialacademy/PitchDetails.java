package ca.greyham.socialacademy;

public class PitchDetails {
    private String pitchCompany;
    private String pitchBlurb;
    private String pitchCampaignName;
    private String videoURL;
    private String pitchSponsor;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPitchCompany() {
        return pitchCompany;
    }

    public void setPitchCompany(String pitchCompany) {
        this.pitchCompany = pitchCompany;
    }

    public String getPitchBlurb() {
        return pitchBlurb;
    }

    public void setPitchBlurb(String pitchBlurb) {
        this.pitchBlurb = pitchBlurb;
    }

    public String getPitchCampaignName() {
        return pitchCampaignName;
    }

    public void setPitchCampaignName(String pitchCampaignName) {
        this.pitchCampaignName = pitchCampaignName;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getPitchSponsor() {
        return pitchSponsor;
    }

    public void setPitchSponsor(String pitchSponsor) {
        this.pitchSponsor = pitchSponsor;
    }
}
