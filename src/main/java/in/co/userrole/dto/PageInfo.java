package in.co.userrole.dto;

public class PageInfo {

  private String code;
  private String description;

  public String getCode() {
    return code;
  }

  public PageInfo setCode(String code) {
    this.code = code;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public PageInfo setDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return "PageInfo{" + "code='" + code + '\'' + ", description='" + description + '\'' + '}';
  }
}
