public interface ToolSettings {

  public ToolObject getTool(String key);
  public void setTool(String key, ToolObject t);
  public boolean exists(String key);
  static ToolSettings getInstance(){
    return null;
  }
}
