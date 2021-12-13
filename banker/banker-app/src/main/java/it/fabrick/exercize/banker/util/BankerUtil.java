/**
 * 
 */
package it.fabrick.exercize.banker.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author emiliano.bossi
 */
public class BankerUtil {

    /**
     * @param basicAddress
     * @param serviceUri
     * @return
     * @throws URISyntaxException
     */
    public static URI buildURI(String basicAddress, String serviceUri) throws URISyntaxException {
        final StringBuilder appender = baseAppend(basicAddress, serviceUri);
        return new URI(appender.toString());
    }

    /**
     * @param basicAddress
     * @param serviceUri
     * @param pathVars
     * @return
     * @throws URISyntaxException
     */
    public static URI buildURI(String basicAddress, String serviceUri, String... pathVars) throws URISyntaxException {
        final StringBuilder appender = baseAppend(basicAddress, serviceUri);
        appender.append("/");
        appender.append(StringUtils.join(Arrays.asList(pathVars), "/"));
        return new URI(appender.toString());
    }

    /**
     * @param basicAddress
     * @param serviceUri
     * @param queryParams
     * @return
     * @throws URISyntaxException
     */
    public static URI buildURI(String basicAddress, String serviceUri, Collection<Pair<String, String>> queryParams) throws URISyntaxException {
        final StringBuilder appender = baseAppend(basicAddress, serviceUri);
        appender.append("?");
        queryParams.forEach(qParam -> {
            appender.append(qParam.getLeft());
            appender.append("=");
            appender.append(qParam.getRight());
            appender.append("&");
        });
        return new URI(appender.substring(0, (appender.lastIndexOf("&") - 1)));
    }

    /**
     * @param basicAddress
     * @param serviceUri
     * @param pathVars
     * @return
     * @throws URISyntaxException
     */
    public static URI buildURI(String basicAddress, String serviceUri, List<Object> pathVars) throws URISyntaxException {
        final StringBuilder appender = baseAppend(basicAddress, serviceUri);
        appender.append("/");
        appender.append(StringUtils.join(pathVars, "/"));
        return new URI(appender.toString());
    }

    public static String convertStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    /**
     * @param basicAddress
     * @param serviceUri
     * @return
     */
    private static StringBuilder baseAppend(String basicAddress, String serviceUri) {
        final StringBuilder appender = new StringBuilder(basicAddress);
        appender.append(serviceUri);
        return appender;
    }
}
