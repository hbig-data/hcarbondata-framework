package com.ryan.carbondata.test;

import org.apache.carbondata.core.util.CarbonProperties;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.CarbonContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/21 14:41.
 */
public class OthersTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(OthersTestCase.class);

    private static final String storeLocation = "";
    private static final String currentPath = "";
    private String kettleHome = "";


    /**
     *
     * @param appName
     * @return
     */
    private CarbonContext createCarbonContext(String appName){
        JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName(appName).setMaster("local[2]"));
        sc.setLogLevel("ERROR");

        LOG.info("Starting $appName using spark version ${sc.version}");

        CarbonContext cc = new CarbonContext(sc.sc(), storeLocation, currentPath + "/target/carbonmetastore");

        // .addProperty("carbon.storelocation", storeLocation);
        CarbonProperties.getInstance().addProperty("carbon.storelocation", storeLocation);

        // whether use table split partition
        // true -> use table split partition, support multiple partition loading
        // false -> use node split partition, support data load by host partition
        CarbonProperties.getInstance().addProperty("carbon.table.split.partition.enable", "false");
        return cc;
    }


    public static void main(String[] args) {

    }

}
