/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.model.NhanVienModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface INhanVienService {
        List<NhanVienModel> findByCategoryId(Long categoryId);
	NhanVienModel save(NhanVienModel nhanVienModel);
	NhanVienModel update(NhanVienModel updateNew);
	void delete(long[] ids);
	List<NhanVienModel> findAll();
	int getTotalItem();
	NhanVienModel findOne(long id);
}
