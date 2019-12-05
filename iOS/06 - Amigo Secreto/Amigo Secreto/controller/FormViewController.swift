//
//  ViewController.swift
//  Amigo Secreto
//
//  Created by Valéria Cavalcanti on 05/12/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var tfAmiguinho: UITextField!
    @IBOutlet weak var tfPresente: UITextField!
    @IBOutlet weak var tfValor: UITextField!
    

    @IBAction func salvar(_ sender: Any) {
        let amiguinho = self.tfAmiguinho.text
        let presente = self.tfPresente.text
        let valor = Float(self.tfValor.text!)
        
        let confra = Confra(amiguinho: amiguinho!, descricao: presente!, valor: valor!)
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        delegate.cadastro.add(confra: confra)
        
        self.navigationController?.popViewController(animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("Form - viewDidLoad")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        print("Form - viewWillAppear")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        print("Form - viewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        
        print("Form - viewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        
        print("Form - viewDidDisappear")
    }
}

