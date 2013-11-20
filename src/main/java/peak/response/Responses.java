package vis.servlet.response;

import fj.F;

public class Responses
{
    public static ResponseBuilder plainText(String string)
    {
        return SetContentType.plain.and(new StringResponse(string));
    }

    public static <T> ResponseBuilder json(T value, F<T, String> mapper)
    {
        return SetContentType.json.and(new JsonResponse<T>(value, mapper));
    }
}
