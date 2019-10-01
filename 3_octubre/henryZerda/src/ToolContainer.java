public interface ToolContainer {
  public Tool getTool(String key);
  public void setTool(String key, Tool t);
  public boolean exists(String key);
}
