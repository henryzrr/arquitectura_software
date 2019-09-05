import java.util.List;

public  interface Tool{
    void applyTool()throws Exception;
    void setToolParams(List<String> params);
}
