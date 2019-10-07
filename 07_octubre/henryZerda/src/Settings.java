public interface Settings {
  public boolean isUnix();
  public char getVolume();
  public void setVolume(char vol);
  public String getDir(String key);
  public void setDir(String key, String path);
  public boolean exists(String key);
  static Settings getInstance(){
    return null;
  }
}
