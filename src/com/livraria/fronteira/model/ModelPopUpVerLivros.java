package com.livraria.fronteira.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.livraria.entidades.Livro;

@SuppressWarnings("serial")
public class ModelPopUpVerLivros extends DefaultTableModel
{
	private static final int COLUNA_ISBN = 1;
	private static final int COLUNA_TITULO = 2;
	private static final int COLUNA_PRECO = 3;
	private static final int COLUNA_PAGINAS = 4;

	private static final String COLUNS[] = new String[]
	{
		"ISBN", "T�tulo", "Pre�o", "P�ginas",
	};

	private static final Class<?> COLUNS_TYPE[] = new Class[]
	{
		String.class, String.class, Float.class, Integer.class, String.class, String.class
	};

	private List<Livro> livros = new ArrayList<Livro>();

	@Override
	public Class<?> getColumnClass(int column)
	{
		return COLUNS_TYPE[column];
	}

	@Override
	public int getColumnCount()
	{
		return COLUNS.length;
	}

	@Override
	public String getColumnName(int column)
	{
		return COLUNS[column];
	}

	@Override
	public int getRowCount()
	{
		return livros == null ? 0 : livros.size();
	}

	@Override
	public Object getValueAt(int row, int column)
	{
		Livro livro = livros.get(row);

		if (livro != null)
			switch (column)
			{
				case COLUNA_ISBN: livro.getIsbn();
				case COLUNA_TITULO: livro.getTitulo();
				case COLUNA_PRECO: livro.getPreco();
				case COLUNA_PAGINAS: livro.getPaginas();
			}

		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1)
	{
		return false;
	}

	public Livro getLinha(int linha)
	{
		return livros.get(linha);
	}
	
	public void removerLinha(int linha)
	{
		livros.remove(linha);

		fireTableDataChanged();
	}

	public void atualizarLista(List<Livro> lista)
	{
		livros = lista;

		fireTableDataChanged();
	}
}