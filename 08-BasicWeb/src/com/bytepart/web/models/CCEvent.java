
package com.bytepart.web.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CCEvent {

    @SerializedName("after")
    private String mAfter;
    @SerializedName("base_ref")
    private Object mBaseRef;
    @SerializedName("before")
    private String mBefore;
    @SerializedName("commits")
    private List<Commit> mCommits;
    @SerializedName("compare")
    private String mCompare;
    @SerializedName("created")
    private Boolean mCreated;
    @SerializedName("deleted")
    private Boolean mDeleted;
    @SerializedName("forced")
    private Boolean mForced;
    @SerializedName("head_commit")
    private HeadCommit mHeadCommit;
    @SerializedName("pusher")
    private Pusher mPusher;
    @SerializedName("ref")
    private String mRef;
    @SerializedName("repository")
    private Repository mRepository;
    @SerializedName("sender")
    private Sender mSender;

    public String getAfter() {
        return mAfter;
    }

    public void setAfter(String after) {
        mAfter = after;
    }

    public Object getBaseRef() {
        return mBaseRef;
    }

    public void setBaseRef(Object baseRef) {
        mBaseRef = baseRef;
    }

    public String getBefore() {
        return mBefore;
    }

    public void setBefore(String before) {
        mBefore = before;
    }

    public List<Commit> getCommits() {
        return mCommits;
    }

    public void setCommits(List<Commit> commits) {
        mCommits = commits;
    }

    public String getCompare() {
        return mCompare;
    }

    public void setCompare(String compare) {
        mCompare = compare;
    }

    public Boolean getCreated() {
        return mCreated;
    }

    public void setCreated(Boolean created) {
        mCreated = created;
    }

    public Boolean getDeleted() {
        return mDeleted;
    }

    public void setDeleted(Boolean deleted) {
        mDeleted = deleted;
    }

    public Boolean getForced() {
        return mForced;
    }

    public void setForced(Boolean forced) {
        mForced = forced;
    }

    public HeadCommit getHeadCommit() {
        return mHeadCommit;
    }

    public void setHeadCommit(HeadCommit headCommit) {
        mHeadCommit = headCommit;
    }

    public Pusher getPusher() {
        return mPusher;
    }

    public void setPusher(Pusher pusher) {
        mPusher = pusher;
    }

    public String getRef() {
        return mRef;
    }

    public void setRef(String ref) {
        mRef = ref;
    }

    public Repository getRepository() {
        return mRepository;
    }

    public void setRepository(Repository repository) {
        mRepository = repository;
    }

    public Sender getSender() {
        return mSender;
    }

    public void setSender(Sender sender) {
        mSender = sender;
    }

}
