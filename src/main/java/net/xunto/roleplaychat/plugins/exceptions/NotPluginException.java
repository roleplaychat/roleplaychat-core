package net.xunto.roleplaychat.plugins.exceptions;

public class NotPluginException extends PluginLoadException {

  public NotPluginException(Object o) {
    super(String.format("The created object (%s) is not a plugin", o.toString()));
  }
}
