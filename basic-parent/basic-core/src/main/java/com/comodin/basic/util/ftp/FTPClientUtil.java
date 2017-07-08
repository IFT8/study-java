package com.comodin.basic.util.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class FTPClientUtil {
    private static Logger log = Logger.getLogger(FTPClientUtil.class);

    private static ThreadLocal<FTPClient> ftpClientThreadLocal;
    private static ThreadLocal<FTPClientConfigBean> ftpClientConfigBeanThreadLocal;
    private static List<String> listFileNames;

    static {
        ftpClientThreadLocal = new ThreadLocal<>();
        ftpClientConfigBeanThreadLocal = new ThreadLocal<>();
        listFileNames = new ArrayList<>();
    }

    /**
     * 获取FTP客户端连接
     *
     * @return //
     *
     * @throws FTPClientException
     * @throws IOException
     */
    private static FTPClient getFTPClient() throws FTPClientException, IOException {
        if (ftpClientThreadLocal.get() != null && ftpClientThreadLocal.get().isConnected()) {
            return ftpClientThreadLocal.get();
        } else {
            FTPClient ftpClient = new FTPClient();          // 构造一个FtpClient实例
            ftpClient.setControlEncoding(ftpClientConfigBeanThreadLocal.get().getEncoding());         // 设置字符集
            ftpClient.setConnectTimeout(ftpClientConfigBeanThreadLocal.get().getClientTimeout());     //设置连接超时时间
            ftpClient.connect(ftpClientConfigBeanThreadLocal.get().getHost(), ftpClientConfigBeanThreadLocal.get().getPort());

            int reply = ftpClient.getReplyCode();           // 连接后检测返回码来校验连接是否成功
            if (FTPReply.isPositiveCompletion(reply)) {     // 登陆到ftp服务器
                ftpClient.login(ftpClientConfigBeanThreadLocal.get().getUsername(), ftpClientConfigBeanThreadLocal.get().getPassword());
                setFileType(ftpClient);                     // 设置文件传输类型
            } else {
                ftpClient.disconnect();
            }
            if (ftpClientConfigBeanThreadLocal.get().isPassiveMode()) {
                ftpClient.enterLocalPassiveMode();
            }

            ftpClientThreadLocal.set(ftpClient);
            return ftpClient;
        }
    }

    /**
     * @throws FTPClientException
     * @throws IOException
     * @description 设置文件传输类型
     */
    private static void setFileType(FTPClient ftpClient) throws FTPClientException, IOException {
        if (ftpClientConfigBeanThreadLocal.get().isBinaryTransfer()) {
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        } else {
            ftpClient.setFileType(FTPClient.ASCII_FILE_TYPE);
        }
    }

    /**
     * @throws FTPClientException
     * @throws IOException
     * @description 断开ftp连接
     */
    public static void disconnect() throws FTPClientException, IOException {
        FTPClient ftpClient = getFTPClient();
        ftpClient.logout();
        if (ftpClient.isConnected()) {
            ftpClient.disconnect();
            ftpClient = null;
            ftpClientThreadLocal.set(ftpClient);
        }
    }

    /**
     * @param delFiles
     *
     * @return
     *
     * @throws FTPClientException
     * @throws IOException
     * @description 批量删除所有目录下的对应的文件
     */
    public static boolean deleteRemoteFiles(String[] delFiles) throws FTPClientException, IOException {
        List<String> list = listNames();//获取所有的文件名
        for (String filename : delFiles) {
            for (String filepath : list) {
                if (filepath.contains(filename)) {//如果该路径包含该文件名则删除
                    boolean result = getFTPClient().deleteFile(filepath);
                    if (!result) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * @return 远程默认目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组
     *
     * @throws FTPClientException
     * @throws IOException
     * @description 列出远程默认目录下所有的文件
     */
    public static List<String> listNames() throws FTPClientException, IOException {
        return listNames(null);
    }

    public static List<String> listNames(String remotePath) throws FTPClientException, IOException {
        return listNames(remotePath, true);
    }

    /**
     * @param remotePath 远程目录名
     *                   //@param autoClose  是否自动关闭当前连接
     *
     * @return 远程目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组
     *
     * @throws FTPClientException
     * @throws IOException
     * @description 列出远程目录下所有的文件
     */
    public static List<String> listNames(String remotePath, boolean containSubdirectory) throws FTPClientException, IOException {
        if (null == remotePath) {
            remotePath = "." + File.separator;
        }
        try {
            FTPFile[] files = getFTPClient().listFiles(remotePath);
            if (files.length < 3) {
                return listFileNames;
            }
            for (FTPFile file : files) {
                if (!file.getName().equals(".") && !file.getName().equals("..")) {
                    if (file.isFile()) {// 文件
                        listFileNames.add("." + File.separator + file.getName());
                    } else {// 目录
                        listNames2(remotePath + file.getName() + File.separator, containSubdirectory);
                    }
                }
            }
        } catch (IOException e) {
            throw new FTPClientException("列出远程目录下所有的文件时出现异常", e);
        }
        return listFileNames;
    }

    //listNames2递归方法
    private static void listNames2(String remotePath, boolean containSubdirectory) throws FTPClientException {
        try {
            FTPClient client = getFTPClient();
            client.changeWorkingDirectory(remotePath);
            FTPFile[] files = client.listFiles(remotePath);
            if (files.length < 3) {
                return;
            }
            for (FTPFile file : files) {
                if (!file.equals(".") && !file.equals("..")) {
                    if (file.isFile()) {
                        listFileNames.add(remotePath + file.getName());
                    }
                    if (file.isDirectory() && (!".".equals(file.getName())) && (!"..".equals(file.getName()))) {
                        String path = remotePath + file.getName() + File.separator;
                        listNames2(path, containSubdirectory);
                    }
                }
            }
        } catch (IOException e) {
            throw new FTPClientException("列出远程目录下所有的文件时出现异常", e);
        }
    }


    public static boolean uploadToRemote(String host, int port, String username, String password, String remotePath, String fileName, InputStream localInputStream) throws IOException, FTPClientException {
        FTPClientConfigBean ftpClientConfigBean = new FTPClientConfigBean(host, port, username, password);
        return uploadToRemote(ftpClientConfigBean, remotePath, fileName, localInputStream);
    }

    /**
     * @param remotePath       远程路径
     * @param fileName         要上传的文件名
     * @param localInputStream 本地InputStream流
     *
     * @return
     *
     * @throws IOException
     * @throws FTPClientException
     */
    public static boolean uploadToRemote(FTPClientConfigBean clientConfigBean, String remotePath, String fileName, InputStream localInputStream) throws IOException, FTPClientException {
        ftpClientConfigBeanThreadLocal.set(clientConfigBean);
        FTPClient client = getFTPClient();
        int reply;
        reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
        }
        if (!client.changeWorkingDirectory(remotePath)) {
            mkdirs(remotePath);
        }
        boolean result = client.storeFile(fileName, localInputStream);
        localInputStream.close();
        return result;
    }

    /**
     * @param remotePath 远程路径
     * @param localPath  本地路径
     *
     * @return
     *
     * @throws IOException
     * @throws FTPClientException
     * @throws IOException
     */
    public static boolean downloadToLocal(String remotePath, String localPath) throws FTPClientException, IOException {
        return downloadToLocal(remotePath, localPath, (String[]) null);
    }

    /**
     * @param remotePath 远程路径
     * @param localPath  要下载的路径
     * @param fileNames  所有要下载的文件名字
     *
     * @return
     *
     * @throws IOException
     * @throws FTPClientException
     * @throws IOException
     */
    public static boolean downloadToLocal(String remotePath, String localPath, String... fileNames) throws IOException, FTPClientException {
        remotePath = remotePath + File.separator;
        localPath = localPath + File.separator;
        FTPClient client = getFTPClient();
        client.changeWorkingDirectory(remotePath);
        FTPFile[] ftpList = client.listFiles(remotePath);
        boolean result = true;
        if (null == fileNames) {
            for (FTPFile f : ftpList) {
                if (f.getSize() > 0) {
                    File file = new File(localPath);
                    file.mkdirs();
                    OutputStream out = new FileOutputStream(localPath + f.getName());
                    result = client.retrieveFile(f.getName(), out); // 下载
                    out.close();
                    if (!result) {
                        break;
                    }
                }
            }
        } else {
            for (String fileName : fileNames) {
                File file = new File(localPath);
                file.mkdirs();
                OutputStream out = new FileOutputStream(localPath
                        + File.separator + fileName);
                result = client.retrieveFile(fileName, out); // 下载
                out.close();
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param fileName 远程路径名
     *
     * @return
     *
     * @throws IOException
     * @throws FTPClientException
     */
    public static int getRemoteFileSize(String fileName) throws IOException, FTPClientException {
        FTPClient client = getFTPClient();
        int size = 0;
        FTPFile[] ftpList = client.listFiles();
        for (FTPFile f : ftpList) {
            if (f.getName().equalsIgnoreCase(fileName)) {
                size = (int) f.getSize();
            }
        }
        return size;
    }

    /**
     * @param filename  要下载的文件名 从整个服务器中查找,可能找到多个相同名字的文件,按在服务端的路径在指定本地路径下创建想对应的路径和文件
     * @param localPath 本地路径
     *
     * @return
     *
     * @throws Exception
     */
    public static boolean downloadToLocal2(String filename, String localPath) throws Exception {
        List<String> list = listNames();
        OutputStream out;
        try {
            for (String filepath : list) {
                if (filepath.contains(filename)) {
                    String remoteFilePath = filepath.substring(1, filepath.length());
                    File file = new File(localPath + remoteFilePath);
                    new File(file.getParent()).mkdirs();
                    out = new FileOutputStream(localPath + remoteFilePath);
                    getFTPClient().retrieveFile(filepath, out); // \u4E0B\u8F7D
                    out.close();
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param remoteDir 远程目录
     *
     * @return
     *
     * @throws SocketException
     * @throws IOException
     * @throws FTPClientException
     * @description 创建远程目录允许创建多级目录
     */
    public static boolean mkdirs(String remoteDir) throws IOException, FTPClientException {
        log.info("mkdirs remoteDir: \t" + remoteDir);

        //先访问FTP根目录
        String currentDir = "/";
        FTPClientUtil.getFTPClient().changeWorkingDirectory(currentDir);
        log.info("mkdirs remoteDir===>>> cd rootDir: " + currentDir + "\t result: " + FTPClientUtil.getFTPClient().printWorkingDirectory());

        //String currentDir = FTPClientUtil.getFTPClient().printWorkingDirectory();
        //log.info("mkdirs remoteDir===>>> cd Ftp Default Dir: " + currentDir);


        //开始遍历，remoteDir目录
        String[] dirs = remoteDir.split("/");
        for (String dir : dirs) {
            if (dir == null || "".equals(dir.trim())) {
                continue;
            }

            currentDir = (currentDir + "/" + dir + "/").replaceAll("//", "/");
            boolean currentDirWhetherExist = FTPClientUtil.getFTPClient().changeWorkingDirectory(currentDir);
            log.info("mkdirs remoteDir===>>> cd currentDir: " + currentDir + "\tresult: " + currentDirWhetherExist);
            if (!currentDirWhetherExist) {
                boolean makeDirectory = FTPClientUtil.getFTPClient().makeDirectory(dir);
                log.info("mkdirs remoteDir===>>> mkdir currentDir: " + currentDir + "\tresult: " + makeDirectory);
                FTPClientUtil.getFTPClient().changeWorkingDirectory(currentDir);
            }
        }
        return true;
    }
}