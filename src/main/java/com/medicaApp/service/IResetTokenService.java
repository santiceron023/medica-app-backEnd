package com.medicaapp.service;

import com.medicaapp.model.ResetToken;

public interface IResetTokenService {
	
	void guardar(ResetToken token);
	void eliminar(ResetToken token);
	ResetToken findByToken(String userName);

}
