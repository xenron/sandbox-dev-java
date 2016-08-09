package packt;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class UsingThePlatformMXBeans {
    
    public static void main(String[] args) {
        RuntimeMXBean mxBean = ManagementFactory.getPlatformMXBean(RuntimeMXBean.class);

        System.out.println("JVM Name: " + mxBean.getName());
        System.out.println("JVM Specification Name: " + mxBean.getSpecName());
        System.out.println("JVM Specification Version: " + mxBean.getSpecVersion());
        System.out.println("JVM Implemenation Name: " + mxBean.getVmName());
        System.out.println("JVM Implemenation Vendor: " + mxBean.getVmVendor());
        System.out.println("JVM Implemenation Version: " + mxBean.getVmVersion());

        // Using the getPlatformMXBeans method        
        List<OperatingSystemMXBean> list =
                ManagementFactory.getPlatformMXBeans(OperatingSystemMXBean.class);
        System.out.println("size: " + list.size());
        for (OperatingSystemMXBean bean : list) {
            System.out.println("Operating System Name: " + bean.getName());
            System.out.println("Operating System Architecture: " + bean.getArch());
            System.out.println("Operating System Version: " + bean.getVersion());
        }
        
    }
    
}
