/**
 * IP地址与整数的转换。
 * 本题需要具备ip地址相关知识，ip地址实际上是由4个单字节长度的无符号整数拼接在一起的。一个单字节无符号整数最大值是255。
 * 所以在ip地址中的每一段的取值范围都是0～255共256个数值
 */
package integration;

public class IpIntegerConversion {
        // 将 IP 地址转换为整数
        public static long ipToLong(String ipAddress) {
            String[] ipAddressInArray = ipAddress.split("\\.");
            long result = 0;
            for (int i = 0; i < ipAddressInArray.length; i++) {
                int power = 3 - i;
                int ip = Integer.parseInt(ipAddressInArray[i]);
                //ip地址段乘以该段所代表的位权中，由于一个段有256个数值所以此处是256的幂次方
                result += ip * Math.pow(256, power);
            }
            return result;
        }
    
        // 将整数转换为 IP 地址
        public static String longToIp(long ip) {
            StringBuilder sb = new StringBuilder();
            //从左往右依次提取每个字节，第一次右移三个字节使原来四个字节的数据，只剩一个字节，因为右移的时候会用0来补最左侧的位置。
            //与255做位与运算是为了只保留最后一个想要的字节。比如原本四个字节的数据，想要左数第二个字节，此时的做法是右移两位。
            //让左数第二个字节成为右数第一个，但此时如果不与255做位与运算，那其左侧的第一个字节也会被保留下来。此时做位与后就只保留了想要的字节。
            for (int i = 3; i >= 0; i--) {
                sb.append((ip >> (i * 8)) & 255);
                if (i > 0) {
                    sb.append(".");
                }
            }
            return sb.toString();
        }
    
        public static void main(String[] args) {
            String ip = "192.168.1.1";
            long ipLong = ipToLong(ip);
            System.out.println("IP 地址 " + ip + " 转换为整数是: " + ipLong);
            String newIp = longToIp(ipLong);
            System.out.println("整数 " + ipLong + " 转换为 IP 地址是: " + newIp);
        }
}
