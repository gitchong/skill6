package cn.skill6.common.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;

import cn.skill6.common.constant.Encode;

/**
 * 读取配置文件工具类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年2月28日 上午10:10:33
 */
public class ReadConfigFile {
  /**
   * 读取类路径下的文件（只要在类路径下即可）
   *
   * @param fileRelativePath
   * @throws UnsupportedEncodingException
   * @throws IOException
   */
  public static Properties readByRelativePath(String fileRelativePath)
      throws UnsupportedEncodingException, IOException {
    Properties properties = new Properties();

    // 使用ClassLoader加载properties配置文件生成对应的输入流
    InputStream in = ReadConfigFile.class.getClassLoader().getResourceAsStream(fileRelativePath);
    // 使用properties对象加载输入流
    properties.load(new InputStreamReader(in, Encode.DEFAULT_ENCODE));

    return properties;
  }

  /**
   * 读取类路径下的文件（需要指定相对类根目录路径） 注意:只能读取类路径下的,不能读取resources下的.估计编译后能够读取.并且被读取的文件名称不加后缀.
   * 这是国际化的类,所以要加zh_CN类似的. <br>
   * config为属性文件名,放在包com.test.config下,如果是放在src下,直接用config即可
   *
   * @param fileClassPath 无后缀的文件名称
   * @throws UnsupportedEncodingException
   * @throws IOException
   */
  public static ResourceBundle readByClassPath(String fileClassPath)
      throws UnsupportedEncodingException, IOException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(fileClassPath);

    return resourceBundle;
  }

  /**
   * 读取绝对路径下的文件
   *
   * @param fileAbsolutePath
   * @throws IOException
   */
  public static Properties readByAbsolutePath(String fileAbsolutePath) throws IOException {
    Properties properties = new Properties();

    InputStreamReader inputStreamReader =
        new InputStreamReader(new FileInputStream(fileAbsolutePath), Encode.DEFAULT_ENCODE);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    // 使用InPutStream流读取properties文件
    properties.load(bufferedReader);

    return properties;
  }
}
