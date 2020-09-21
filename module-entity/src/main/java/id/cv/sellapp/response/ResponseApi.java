package id.cv.sellapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {

    private int code;
    private String message;
    private Object data;
    private int total;

    public static ResponseApi responseApi(int code, String message,  Object data, int total){

        ResponseApi responseApi = null;
        switch (code) {
            case 200 :
                responseApi = new ResponseApi();
                responseApi.setTotal(total);
                responseApi.setMessage(message);
                responseApi.setData(data);
                responseApi.setCode(200);
                break;
            case 400:
                responseApi = new ResponseApi();
                responseApi.setTotal(total);
                responseApi.setMessage(message);
                responseApi.setData(data);
                responseApi.setCode(400);
                break;
            case 404:
                responseApi = new ResponseApi();
                responseApi.setTotal(total);
                responseApi.setMessage(message);
                responseApi.setData(data);
                responseApi.setCode(404);
                break;
        }

        return responseApi;
    }
}
