package dao;

import java.util.List;

import entity.TbProduct;


public interface ProductDAO {
	public List<TbProduct> getAllProduct();
	public TbProduct getProductById(String id);
	public boolean insertProduct(TbProduct product);
	public boolean updateProduct(TbProduct product);
	public boolean deleteProduct(String id);
}
