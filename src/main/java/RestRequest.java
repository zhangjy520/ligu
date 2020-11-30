import lombok.Data;

/**
 * zhangwd
 *
 * @param <T>
 */
@Data
public class RestRequest<T> {
    private CommonParam commonParam;
    private T body;
}
