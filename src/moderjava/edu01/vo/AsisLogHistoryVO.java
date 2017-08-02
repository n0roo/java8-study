package moderjava.edu01.vo;

import java.time.LocalDateTime;

public class AsisLogHistoryVO {

    public enum PROCESS { SIGNUP, SIGNIN, VIEWCONTENT, WRITETAILS, LIKETAILS, SIGNOUT, WITHDRAWUSER }

    private Long loggedAt;
    private PROCESS process;
    private String uuid;
    private String userName;

    public Long getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(Long loggedAt) {
        this.loggedAt = loggedAt;
    }

    public PROCESS getProcess() {
        return process;
    }

    public void setProcess(PROCESS process) {
        this.process = process;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LogHistoryVO{" +
                "loggedAt=" + loggedAt +
                ", process=" + process +
                ", uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
