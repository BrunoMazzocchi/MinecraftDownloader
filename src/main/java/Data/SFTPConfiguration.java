package Data;

import com.jcraft.jsch.*;
public class SFTPConfiguration  {
    public static ChannelSftp setupJsch(String username, String remoteHost, String privateKey) throws JSchException {
        int port = 22;
        JSch jsch = new JSch();
        jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
        jsch.addIdentity(privateKey);
        Session jschSession = jsch.getSession(username, remoteHost, port);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);
        jschSession.connect();

        System.out.println("session connected.....");



        return (ChannelSftp) jschSession.openChannel("sftp");
    }
}