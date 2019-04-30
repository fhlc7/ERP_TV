package com.tvcaxias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.tvcaxias.entidades.Item;
import com.tvcaxias.utils.FHLC;

public class ItemDAO {

	public static long inserir(Connection con, Item item) throws SQLException {
		String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int i = 1;
		ps.setLong(i++, item.getId());
		ps.setString(i++, item.getDescricao());
		ps.setObject(i++, FHLC.calendarTimestamp(item.getEntrada()));
		ps.setObject(i++, FHLC.calendarTimestamp(item.getSaida()));
		ps.setString(i++, item.getStatus());
		ps.setString(i++, item.getQuem());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		long id = 0;
		if (rs.next()) {
			id = rs.getLong(1);
		}
		rs.close();
		ps.close();
		return id;
	}
	
	public static List<Item> selecionar(Connection con) throws SQLException, ParseException {
		List<Item> list = new ArrayList<Item>();
		String sql = "SELECT * FROM item;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Item item = new Item();
			int i = 1;
			item.setId(rs.getLong(i++));
			item.setDescricao(rs.getString(i++));
			item.setEntrada(FHLC.timestampCalendar(rs.getString(i++)));
			item.setSaida(FHLC.timestampCalendar(rs.getString(i++)));
			item.setStatus(rs.getString(i++));
			item.setQuem(rs.getString(i++));
			list.add(item);
		}
		rs.close();
		ps.close();
		return list;
	}
	
}
