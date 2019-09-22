package main;

import java.util.List;

public interface ICommandParser {

    public List<String> getValidTokens() throws Exception;
}
