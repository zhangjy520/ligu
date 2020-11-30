import lombok.Data;

/**
 * zhangwd 请求头信息
 */
@Data
public class CommonParam {
    private String appId;
    private String nonce;
    private long timestamp;
    private String sign;
}
