package Data;
import org.apache.commons.io.FileUtils;
import com.jcraft.jsch.*;
import lombok.*;
import org.springframework.core.io.*;

import java.io.*;
import java.util.*;

@Data
public class Download {
    private String username = "opc";
    private String host = "193.122.148.244";
    private String file = "C:/Users/Bemaz/Downloads/ssh-key-2022-08-31.key";

    public Download(){

    }
    public void DownloadController() throws JSchException, SftpException, IOException {
        ChannelSftp sftp = SFTPConfiguration.setupJsch(this.getUsername(), this.getHost(), this.getFile());
        sftp.connect();

        String remoteFile = "/home/opc/Fabric1.19.2/mods/*";
        String user = System.getProperty("user.name");
        String localDir = "C:/Users/" + user + "/AppData/Roaming/.minecraft/mods";

        File directory = new File(localDir);
        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (directory.length() > 0) {
                FileUtils.cleanDirectory(directory);
                sftp.get(remoteFile, localDir);
            } else {
                sftp.get(remoteFile, localDir);
            }
        }
        sftp.exit();
    }
}

