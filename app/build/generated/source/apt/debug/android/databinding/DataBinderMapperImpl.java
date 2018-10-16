package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.trang.ez_mobile.DataBinderMapperImpl());
  }
}
